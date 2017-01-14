package com.cpt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.mapper.ProductTypeMapper;
import com.cpt.model.ProductType;
import com.cpt.service.ProductTypeService;

@Service
public class productTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeMapper productTypeMapper;
	
	@Override
	public List<ProductType> selectAll() {
		return productTypeMapper.selectAll();
	}

}
