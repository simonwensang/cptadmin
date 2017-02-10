package com.cpt.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.model.Expenses;
import com.cpt.req.ExpensesQuery;
import com.cpt.service.ExpensesService;
import com.cpt.service.UserCommonService;
import com.cpt.vo.EchartVo;

@Controller
@RequestMapping("/expenses")
public class ExpensesController {

	@Autowired 
	private ExpensesService expensesService;
	@Resource
	private UserCommonService userCommonService;
	@RequestMapping("/list")
	public ModelAndView list (ModelAndView modelMap){
		EchartVo echartVo = expensesService.getDepartmentExpenses();
		modelMap.addObject("title",echartVo.getTitle());
		modelMap.addObject("data",echartVo.getValue());
		modelMap.addObject("user",userCommonService.getUser());
		modelMap.setViewName("expenses/expenses_list");
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
    public PageResult<Expenses> pageList(PageParam pageParam, ExpensesQuery expensesQuery) {
        return expensesService.pageList(pageParam, expensesQuery);
    }
    /**
     * 分页数据
     *
     * @param UserQuery
     * @param user
     * @return
     */
  /*  @ResponseBody
    @RequestMapping(value = "/record/pageList", method = RequestMethod.GET)
    public PageResult<Expenses> recordPageList(PageParam pageParam, ExpensesQuery expensesQuery) {
        return expensesService.recordPageList(pageParam, expensesQuery);
    }*/
    
    /**
     * 增加或者修改
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> addOrEdit(Expenses expenses) {
    	return expensesService.addOrEdit(expenses);
    }
	
	@RequestMapping("/detail")
	public ModelAndView detail (ModelAndView modelMap,Long id){
		if(id!=null){
			modelMap.addObject("expensesVo",expensesService.get(id));
		}
		modelMap.setViewName("expenses/expenses_detail");
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
    	return expensesService.delete(id);
    }
}
