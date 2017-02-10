package com.cpt.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.MessageConstants;
import com.cpt.common.constant.UserIdentity;
import com.cpt.mapper.ExpensesMapper;
import com.cpt.mapper.OrganizationMapper;
import com.cpt.mapper.UserMapper;
import com.cpt.mapper.ext.ExpensesExtMapper;
import com.cpt.model.Expenses;
import com.cpt.model.Organization;
import com.cpt.model.OrganizationExample;
import com.cpt.model.User;
import com.cpt.model.UserExample;
import com.cpt.req.ExpensesQuery;
import com.cpt.service.ExpensesService;
import com.cpt.service.UserCommonService;
import com.cpt.vo.DepartmentExpenses;
import com.cpt.vo.EchartVo;
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
	
	public EchartVo getDepartmentExpenses() {
		EchartVo echartVo =new EchartVo();
		 List<DepartmentExpenses> departmentExpenses= Lists.newArrayList();
		 User user = userCommonService.getUser();
		 OrganizationExample example=new OrganizationExample();
		 OrganizationExample.Criteria criteria = example.createCriteria()  ;
		 criteria.andParentIdEqualTo(user.getDepartmentId());
		 List<Organization> organizations = organizationMapper.selectByExample(example);
		 
		 if(organizations.size()>0){
			 List<Long> ids = Lists.newArrayList();
			 JSONArray jsonArray=new JSONArray(); 
			 for (Organization organization : organizations){
				 ids.add(organization.getId());
				 jsonArray.add(organization.getName());
			 }
			 echartVo.setTitle(jsonArray.toJSONString());
			 departmentExpenses = expensesExtMapper.selectListDepartment(ids);
		 }
		 JSONArray jsonArray=new JSONArray(); 
		 for(DepartmentExpenses departmentExpense:departmentExpenses)  
		    {  
		        JSONObject jsonObject=new JSONObject();  
		        jsonObject.put("name",departmentExpense.getDepartment());  
		        jsonObject.put("value",departmentExpense.getTotal());  
		        jsonArray.add(jsonObject);  
		    }  
		 echartVo.setValue(jsonArray.toJSONString());
		 return echartVo;
	}
	 
	private List<DepartmentExpenses> setRadio(List<DepartmentExpenses> list){
		BigDecimal total = BigDecimal.ZERO;
		for (DepartmentExpenses departmentExpenses:list) {
			total.add(departmentExpenses.getTotal());
		}
		
		for (DepartmentExpenses departmentExpenses:list) {
			departmentExpenses.setRatio(departmentExpenses.getTotal().divide(total).toString());
		}
		return list;
	}
	
	@Override
	public PageResult<Expenses> pageList(PageParam pageParam,
			ExpensesQuery expensesQuery) {
		//分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        //当前页列表
        if(!userCommonService.getUser().getIdentity().equals(UserIdentity.PRICE_RECORD_IN.getKey())){
        	 expensesQuery.setUserId( userCommonService.getUserId());
        }
        List<Expenses> expensess = expensesExtMapper.pageList(expensesQuery);
        //构造分页结果
        PageResult<Expenses> pageResult = PageResult.newPageResult(expensess, ((Page<Expenses>)expensess).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
	}

	@Override
	public PageResult<Expenses> recordPageList(PageParam pageParam,
			ExpensesQuery expensesQuery) {
		//分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        //当前页列表
        List<Expenses> expensess = expensesExtMapper.pageList(expensesQuery);
        //构造分页结果
        PageResult<Expenses> pageResult = PageResult.newPageResult(expensess, ((Page<Expenses>)expensess).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> addOrEdit(Expenses expenses) {
		
		if(StringUtils.isBlank(expenses.getUser())
				||expenses.getExpenses()==null){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		if(!userCommonService.getUser().getIdentity().equals(UserIdentity.PRICE_RECORD_IN.getKey())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
		}
		UserExample userExample =new UserExample();
		UserExample.Criteria criteria =userExample.createCriteria();
		criteria.andNameEqualTo(expenses.getUser());
		List<User> user =userMapper.selectByExample(userExample);
		if(user.size()==0){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.USER_EMPTY);
		}
		expenses.setUserId(user.get(0).getId());
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
		if(!userCommonService.getUser().getIdentity().equals(UserIdentity.PRICE_RECORD_IN.getKey())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
		}
		return Result.newResult(expensesExtMapper.logicalDelete(id));
	}

	private int insert(Expenses expenses){
		return expensesMapper.insertSelective(expenses);
	}

	private int update(Expenses expenses){
		return expensesMapper.updateByPrimaryKeySelective(expenses);
	}
}
