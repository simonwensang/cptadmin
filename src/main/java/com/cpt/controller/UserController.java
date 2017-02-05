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
import com.cpt.model.User;
import com.cpt.req.UserQuery;
import com.cpt.service.UserService;
import com.cpt.vo.UserVo;
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired 
	private UserService userService;
	
	@RequestMapping("/list")
	public ModelAndView list (ModelAndView modelMap){
		modelMap.setViewName("user/user_list");
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
    public PageResult<User> pageList(PageParam pageParam, UserQuery userQuery) {
        return userService.pageList(pageParam, userQuery);
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
    public Result<Integer> addOrEdit(User user) {
    	return userService.addOrEdit(user);
    }
	
	@RequestMapping("/detail")
	public ModelAndView detail (ModelAndView modelMap,Long id){
		if(id!=null){
			modelMap.addObject("userVo",userService.get(id));
		}
		modelMap.setViewName("user/user_detail");
		return modelMap;
	}
	
	/**
     * 增加或者修改
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/opt", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> opt(UserVo userReq) {
    	return userService.opt(userReq);
    }
 
	@RequestMapping("/query")
	@ResponseBody
	public List<User> query(UserQuery userQuery){
		return userService.query(userQuery);
	}
	
	@RequestMapping("/queryPriceOffer")
	@ResponseBody
	public List<UserVo> queryPriceOffer(){
		return userService.queryPriceOffer();
	}
	
	
	
}
