package com.cpt.service;

import java.util.List;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.model.ProductType;
import com.cpt.req.ProductTypeQuery;

public interface ProductTypeService {

	public List<ProductType> selectAll();
	
	public ProductType get(Long id);
 	
	public PageResult<ProductType> pageList(PageParam pageParam, ProductTypeQuery productTypeQuery);
	
	public Result<Integer> addOrEdit(ProductType productType);
	
	public Result<Integer> delete(Long id);
	
}
