package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.ProductType;
import com.cpt.req.ProductTypeQuery;

public interface ProductTypeExtMapper {

	 List<ProductType> pageList(ProductTypeQuery productTypeQuery);
	 
	 int logicalDelete(Long id);
}
