package com.cpt.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.Constants;
import com.cpt.common.constant.MessageConstants;
import com.cpt.mapper.CustomerMapper;
import com.cpt.mapper.ext.CustomerExtMapper;
import com.cpt.model.Customer;
import com.cpt.model.CustomerExample;
import com.cpt.req.CustomerQuery;
import com.cpt.service.CustomerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private CustomerExtMapper customerExtMapper;
	
	@Override
	public List<Customer> query() {
		CustomerExample example = new CustomerExample();
		CustomerExample.Criteria criteria =example.createCriteria();
		criteria.andIsDeletedEqualTo(false);
		return customerMapper.selectByExample(example);
	}

	@Override
	public Customer get(Long id) {
		return customerMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult<Customer> pageList(PageParam pageParam,
			CustomerQuery customerQuery) {
		//分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        //当前页列表
        List<Customer> customers = customerExtMapper.pageList(customerQuery);
        //构造分页结果
        PageResult<Customer> pageResult = PageResult.newPageResult(customers, ((Page<Customer>)customers).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> addOrEdit(Customer customer) {

		if(StringUtils.isBlank(customer.getName())
				||StringUtils.isBlank( customer.getContact())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		
		if(customer.getId()==null){
			//判断登录名是否重复
			CustomerExample example = new CustomerExample();
			CustomerExample.Criteria criteria = example.createCriteria();
			criteria.andNameEqualTo(customer.getName());
			criteria.andIsDeletedEqualTo(Constants.ISNOTDELETEDBOLN);
			List<Customer> old = customerMapper.selectByExample(example);
			if(old.size()>0){
				return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.CUSTOMER_EXIT);
			}
			return Result.newResult(this.insert(customer));
		}else{
			return Result.newResult(this.update(customer));
		}
	
	}

	@Override
	public Result<Integer> delete(Long id) {
		return Result.newResult(customerExtMapper.logicalDelete(id));
	}

	private int insert(Customer customer){
		return customerMapper.insertSelective(customer);
	}

	private int update(Customer customer){
		return customerMapper.updateByPrimaryKeySelective(customer);
	}
	
}
