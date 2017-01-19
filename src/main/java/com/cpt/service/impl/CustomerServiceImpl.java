package com.cpt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.mapper.CustomerMapper;
import com.cpt.model.Customer;
import com.cpt.model.CustomerExample;
import com.cpt.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<Customer> query() {
		CustomerExample example = new CustomerExample();
		CustomerExample.Criteria criteria =example.createCriteria();
		criteria.andIsDeletedEqualTo(false);
		return customerMapper.selectByExample(example);
	}

}
