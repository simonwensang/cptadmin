package com.cpt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cpt.common.Result;
import com.cpt.model.UserLog;
import com.cpt.service.UserLogService;
import com.cpt.vo.UserLogVo;
@Controller
@RequestMapping("/userLog")
public class UserLogController {

	@Autowired 
	private UserLogService userLogService;
	
	@RequestMapping("/query")
	@ResponseBody
	public  Result<UserLogVo> query(String logTime){
		return userLogService.query(logTime);
	}
	
	@RequestMapping("/list")
	public ModelAndView list (ModelAndView modelMap){
		modelMap.setViewName("userLog/userLog_list");
		return modelMap;
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
    public Result<Integer> addOrEdit(UserLog userLog) {
    	return userLogService.addOrEdit(userLog);
    }
	
	/*@RequestMapping("/detail")
	public ModelAndView detail (ModelAndView modelMap,Long id){
		if(id!=null){
			modelMap.addObject("userLogVo",userLogService.get(id));
		}
		modelMap.setViewName("userLog/userLog_detail");
		return modelMap;
	}
*/
}
