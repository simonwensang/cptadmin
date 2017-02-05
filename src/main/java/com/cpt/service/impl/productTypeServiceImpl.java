package com.cpt.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.Constants;
import com.cpt.common.constant.MessageConstants;
import com.cpt.mapper.ProductTypeMapper;
import com.cpt.mapper.ext.ProductTypeExtMapper;
import com.cpt.model.Customer;
import com.cpt.model.CustomerExample;
import com.cpt.model.ProductType;
import com.cpt.model.ProductTypeExample;
import com.cpt.req.ProductTypeQuery;
import com.cpt.service.ProductTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class productTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeMapper productTypeMapper;
	@Autowired
	private ProductTypeExtMapper productTypeExtMapper;
	
	@Override
	public List<ProductType> selectAll() {
		ProductTypeExample example = new ProductTypeExample();
		ProductTypeExample.Criteria criteria =example.createCriteria();
		criteria.andIsDeletedEqualTo(Constants.ISNOTDELETED);
		return productTypeMapper.selectByExample(example);
	}

	@Override
	public ProductType get(Long id) {
		return productTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult<ProductType> pageList(PageParam pageParam,
			ProductTypeQuery productTypeQuery) {
		//分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        //当前页列表
        List<ProductType> productTypes = productTypeExtMapper.pageList(productTypeQuery);
        //构造分页结果
        PageResult<ProductType> pageResult = PageResult.newPageResult(productTypes, ((Page<ProductType>)productTypes).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
	}

	@Override
	public Result<Integer> addOrEdit(ProductType productType) {
		if(StringUtils.isBlank(productType.getName())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		
		if(productType.getId()==null){
			//判断登录名是否重复
			ProductTypeExample example = new ProductTypeExample();
			ProductTypeExample.Criteria criteria =example.createCriteria();
			criteria.andIsDeletedEqualTo(Constants.ISNOTDELETED);
			criteria.andNameEqualTo(productType.getName());
			List<ProductType> old = productTypeMapper.selectByExample(example);
			if(old.size()>0){
				return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRODUCT_TYPE_EXIT);
			}
			return Result.newResult(this.insert(productType));
		}else{
			return Result.newResult(this.update(productType));
		}
	}
	
	@Override
	public Result<Integer> delete(Long id) {
		return Result.newResult(productTypeExtMapper.logicalDelete(id));
	}

	private int insert(ProductType productType){
		return productTypeMapper.insertSelective(productType);
	}

	private int update(ProductType productType){
		return productTypeMapper.updateByPrimaryKeySelective(productType);
	}
	

}
