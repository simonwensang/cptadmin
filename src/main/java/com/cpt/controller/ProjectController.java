package com.cpt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.model.ProductType;
import com.cpt.req.OptReq;
import com.cpt.req.ProjectReq;
import com.cpt.req.SignContractReq;
import com.cpt.service.CustomerService;
import com.cpt.service.ProductTypeService;
import com.cpt.service.ProjectDescribeService;
import com.cpt.service.ProjectService;
import com.cpt.vo.ProjectVo;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	private static final Logger log =  LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired 
	private ProjectService projectService;
	
	@Autowired 
	private ProductTypeService productTypeService;
	
	@Autowired 
	private CustomerService customerService;
	
	@Autowired 
	private ProjectDescribeService projectDescribeService;
	  /**
     * 公司资料管理列表
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView mav) {
        mav.setViewName("project/project_list");
        return mav;
    }
    /**
     * 公司资料管理列表
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public ModelAndView manager(ModelAndView mav,Long id ) {
    	mav.addObject("projectId", id);
        mav.setViewName("project/manager_list");
        return mav;
    }
    
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
     * 工程创建页面
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView mav) {
    	List<ProductType> productTypeList = productTypeService.selectAll();
        mav.addObject("productTypeList", productTypeList);
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
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
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
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
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
    @RequestMapping(value = "/opt", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> opt( OptReq optReq) {
    	return projectService.opt( optReq);
    }
    /**
     * 签合同
     *
     * @param SignContractReq
     * @return
     */
    @RequestMapping(value = "/signContract", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> signContract( SignContractReq signContractReq) {
    	return projectService.signContract( signContractReq);
    }
    
    /**
     * 报价
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/priceOffer")
    public String priceOffer(ModelMap map ,Long id) {
    	  map.put("projectVo", projectService.detail(id));
    	  map.put("productTypeList", productTypeService.selectAll());
    	  map.put("customerList", customerService.query());
    	  map.put("projectDescribeList",projectDescribeService.queryDescribe(id));
    	  return "project/project_price";
    }
    
    /**
     * 管理
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/projectManager")
    public String projectManager(ModelMap map ,Long id) {
    	  map.put("projectVo", projectService.detail(id));
    	  map.put("productTypeList", productTypeService.selectAll());
    	  map.put("projectDescribeList",projectDescribeService.queryLog(id));
    	  return "project/project_manager";
    }
    

    /**
     * 管理
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/projectInfo")
    public String projectInfo(ModelMap map ,Long id) {
    	  map.put("projectVo", projectService.detail(id));
    	  map.put("productTypeList", productTypeService.selectAll());
    	  map.put("projectDescribeList",projectDescribeService.queryDescribe(id));
    	  map.put("projectLogList",projectDescribeService.queryLog(id));
    	  return "project/project_info";
    }
    
}
