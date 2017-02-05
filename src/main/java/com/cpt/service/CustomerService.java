package com.cpt.service;

import java.util.List;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.model.Customer;
import com.cpt.req.CustomerQuery;

public interface CustomerService {

	public List<Customer> query();
	
	public Customer get(Long id);
 	
	public PageResult<Customer> pageList(PageParam pageParam, CustomerQuery customerQuery);
	
	public Result<Integer> addOrEdit(Customer customer);
	
	public Result<Integer> delete(Long id);
	
}
