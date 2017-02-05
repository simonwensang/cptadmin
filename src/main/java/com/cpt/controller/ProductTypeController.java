package com.cpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.model.Customer;
import com.cpt.model.ProductType;
import com.cpt.req.ProductTypeQuery;
import com.cpt.service.ProductTypeService;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {

	@Autowired 
	private ProductTypeService productTypeService;
	
	@RequestMapping("/list")
	public ModelAndView list (ModelAndView modelMap){
		modelMap.setViewName("productType/productType_list");
		return modelMap;
	}
	 /**
     * 分页数据
     *
     * @param UserQuery
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pageList", method = RequestMethod.GET)
    public PageResult<ProductType> pageList(PageParam pageParam, ProductTypeQuery productTypeQuery) {
        return productTypeService.pageList(pageParam, productTypeQuery);
    }
    
    /**
     * 增加或者修改
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> addOrEdit(ProductType productType) {
    	return productTypeService.addOrEdit(productType);
    }
	
	@RequestMapping("/detail")
	public ModelAndView detail (ModelAndView modelMap,Long id){
		if(id!=null){
			modelMap.addObject("productTypeVo",productTypeService.get(id));
		}
		modelMap.setViewName("productType/productType_detail");
		return modelMap;
	}

	/**
     * 增加或者修改
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> delete(Long id) {
    	return productTypeService.delete(id);
    }
    
}
