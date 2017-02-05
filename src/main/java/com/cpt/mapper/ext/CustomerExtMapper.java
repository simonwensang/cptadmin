package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.Customer;
import com.cpt.req.CustomerQuery;

public interface CustomerExtMapper {
	 List<Customer> pageList(CustomerQuery customerQuery);
	 
	 int logicalDelete(Long id);
}
