package com.cpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpt.common.Result;
import com.cpt.model.ProjectDescribe;
import com.cpt.service.ProjectDescribeService;

@Controller
@RequestMapping(value = "/projectDescribe")
public class ProjectDescribeController {

	@Autowired 
	ProjectDescribeService projectDescribeService ; 
	
	 /**
     * 保存明细
     *
     * @param ProjectDescribe
     * @return
     */
    @RequestMapping(value = "/insertDescribe", method = RequestMethod.POST)
    @ResponseBody
    public Result<ProjectDescribe> insertDescribe( ProjectDescribe projectDescribe) {
    	return projectDescribeService.insertDescribe(projectDescribe);
    }
    
    /**
     * 保存日志
     *
     * @param ProjectDescribe
     * @return
     */
    @RequestMapping(value = "/insertLog", method = RequestMethod.POST)
    @ResponseBody
    public Result<ProjectDescribe> insertLog( ProjectDescribe projectDescribe) {
    	return projectDescribeService.insertLog(projectDescribe);
    }
}
