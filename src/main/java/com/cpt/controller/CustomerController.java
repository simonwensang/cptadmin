package com.cpt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpt.model.Customer;
import com.cpt.service.CustomerService;
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired 
	private CustomerService customerService;
	
	@RequestMapping("/query")
	@ResponseBody
	public List<Customer> query(){
		return customerService.query();
	}
	
}
