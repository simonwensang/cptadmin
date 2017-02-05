package com.cpt.controller;

import java.util.List;

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
import com.cpt.req.CustomerQuery;
import com.cpt.service.CustomerService;
import com.cpt.vo.UserVo;
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
	
	@RequestMapping("/list")
	public ModelAndView list (ModelAndView modelMap){
		modelMap.setViewName("customer/customer_list");
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
    public PageResult<Customer> pageList(PageParam pageParam, CustomerQuery customerQuery) {
        return customerService.pageList(pageParam, customerQuery);
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
    public Result<Integer> addOrEdit(Customer customer) {
    	return customerService.addOrEdit(customer);
    }
	
	@RequestMapping("/detail")
	public ModelAndView detail (ModelAndView modelMap,Long id){
		if(id!=null){
			modelMap.addObject("customerVo",customerService.get(id));
		}
		modelMap.setViewName("customer/customer_detail");
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
    	return customerService.delete(id);
    }
}
