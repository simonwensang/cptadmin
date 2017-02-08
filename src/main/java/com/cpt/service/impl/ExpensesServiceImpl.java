package com.cpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.MessageConstants;
import com.cpt.mapper.ExpensesMapper;
import com.cpt.mapper.OrganizationMapper;
import com.cpt.mapper.UserMapper;
import com.cpt.mapper.ext.ExpensesExtMapper;
import com.cpt.model.Expenses;
import com.cpt.model.Organization;
import com.cpt.model.OrganizationExample;
import com.cpt.model.User;
import com.cpt.req.ExpensesQuery;
import com.cpt.service.ExpensesService;
import com.cpt.service.UserCommonService;
import com.cpt.vo.DepartmentExpenses;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
@Service
public class ExpensesServiceImpl implements ExpensesService {

	@Autowired
	private ExpensesMapper expensesMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ExpensesExtMapper expensesExtMapper;
	@Resource
	private UserCommonService userCommonService;
	@Autowired
	private OrganizationMapper organizationMapper;
	@Override
	public Expenses get(Long id) {
		return expensesMapper.selectByPrimaryKey(id);
	}
	
	public List<DepartmentExpenses> getDepartmentExpenses() {
		 
		 User user = userCommonService.getUser();
		 OrganizationExample example=new OrganizationExample();
		 OrganizationExample.Criteria criteria = example.createCriteria()  ;
		 criteria.andParentIdEqualTo(user.getDepartmentId());
		 List<Organization> organizations = organizationMapper.selectByExample(example);
		
		 if(organizations.size()>0){
			 List<Long> ids = Lists.newArrayList();
			 for (Organization organization : organizations){
				 ids.add(organization.getId());
			 }
			 
		 }
		 
		 return null;
	}
	
	@Override
	public PageResult<Expenses> pageList(PageParam pageParam,
			ExpensesQuery expensesQuery) {
		//分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        //当前页列表
        User user = userCommonService.getUser();
        switch (expensesQuery.getType()){
        	case (byte)0: ; expensesQuery.setUserId(user.getId()); break; 
        	case (byte)2: if(!user.getIdentity().equals(2)){
        					  expensesQuery.setUserId(user.getId());
        				  }
        	;  break; 
        	default : expensesQuery.setUserId(user.getId()); break; 
        }
        
        List<Expenses> expensess = expensesExtMapper.pageList(expensesQuery);
        //构造分页结果
        PageResult<Expenses> pageResult = PageResult.newPageResult(expensess, ((Page<Expenses>)expensess).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> addOrEdit(Expenses expenses) {

		if(expenses.getUserId()==null
				||expenses.getExpenses()==null){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		User user = userMapper.selectByPrimaryKey(expenses.getUserId());
		if(user==null){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.USER_EMPTY);
		}
		expenses.setUser(user.getName());
		if(expenses.getId()==null){
			expenses.setCreatorId(userCommonService.getUserId());
			return Result.newResult(this.insert(expenses));
		}else{
			expenses.setUpdaterId(userCommonService.getUserId());
			return Result.newResult(this.update(expenses));
		}
	
	}

	@Override
	public Result<Integer> delete(Long id) {
		return Result.newResult(expensesExtMapper.logicalDelete(id));
	}

	private int insert(Expenses expenses){
		return expensesMapper.insertSelective(expenses);
	}

	private int update(Expenses expenses){
		return expensesMapper.updateByPrimaryKeySelective(expenses);
	}
}
