package com.cpt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.req.OptReq;
import com.cpt.req.ProjectReq;
import com.cpt.service.ProjectService;
import com.cpt.vo.ProjectVo;

@Controller
public class ProjectController {
	
	private static final Logger log =  LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired 
	private ProjectService projectService;
	
	 /**
     * 分页数据
     *
     * @param pageParam
     * @param projectVo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pageList", method = RequestMethod.GET)
    public PageResult<ProjectVo> pageList(PageParam pageParam, ProjectReq projectReq) {
        return projectService.pageList(pageParam, projectReq);
    }
	
    /**
     * 工程详情
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView detail(ModelAndView mav, Long id) {
    	ProjectVo projectVo = projectService.detail(id);
        mav.addObject("projectVo", projectVo);
        mav.setViewName("project/project_detail");
        return mav;
    }
    /**
     * 工程编辑详情
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView add(ModelAndView mav, Long id) {
    	ProjectVo projectVo = projectService.getProjectById(id);
        mav.addObject("projectVo", projectVo);
        mav.setViewName("project/project_edit");
        return mav;
    }
    /**
     * 增加或者修改工程
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.GET)
    public Result<Integer> addOrEdit(ProjectReq projectReq) {
    	return projectService.addOrEdit(projectReq);
    }
    /**
     * 增加或者修改工程
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/opt", method = RequestMethod.GET)
    public Result<Integer> opt( OptReq optReq) {
    	return projectService.opt( optReq);
    }
}
