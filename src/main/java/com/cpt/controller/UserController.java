package com.cpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cpt.model.User;
import com.cpt.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired 
	private UserService userService;
	
	@RequestMapping("/get")
	public ModelAndView get (ModelAndView modelMap){
		User user =userService.get();
		modelMap.addObject("user",user);
		modelMap.setViewName("user/user-info");
		return modelMap;
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public User queryInfo(){
		return userService.get();
	}
 
}
