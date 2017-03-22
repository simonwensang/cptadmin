package com.cpt.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.AuthorityStatus;
import com.cpt.common.constant.Constants;
import com.cpt.common.constant.MessageConstants;
import com.cpt.common.constant.ProjectStatus;
import com.cpt.common.util.CodeFactory;
import com.cpt.convertor.ProjectConvertor;
import com.cpt.mapper.ProjectMapper;
import com.cpt.mapper.UserMapper;
import com.cpt.mapper.WorkFlowMapper;
import com.cpt.mapper.ext.ProjectExtMapper;
import com.cpt.mapper.ext.WorkFlowExtMapper;
import com.cpt.model.Project;
import com.cpt.model.ProjectExample;
import com.cpt.model.User;
import com.cpt.model.WorkFlow;
import com.cpt.req.OptReq;
import com.cpt.req.ProjectReq;
import com.cpt.req.SignContractReq;
import com.cpt.service.ProjectPriceService;
import com.cpt.service.ProjectService;
import com.cpt.service.UserCommonService;
import com.cpt.vo.ProjectVo;
import com.cpt.vo.ScheduleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Resource
	private ProjectMapper projectMapper;
	@Resource
	private ProjectExtMapper projectExtMapper;
	@Resource
	private UserCommonService userCommonService;
	@Resource
	private UserMapper userMapper;
	@Resource
	private WorkFlowMapper workFlowMapper;
	@Resource
	private WorkFlowExtMapper workFlowExtMapper;
	@Resource
	private ProjectPriceService projectPriceService;
	@Override
	public PageResult<ProjectVo> pageList(PageParam pageParam,
			ProjectReq projectReq) {
		 //分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        //当前页列表
        projectReq.setUserId(userCommonService.getUserId());
        List<ProjectVo> projectVos = projectExtMapper.selectProjectList(projectReq);
        //构造分页结果
        this.packageProjectButton(projectVos);
        PageResult<ProjectVo> pageResult = PageResult.newPageResult(projectVos, ((Page<ProjectVo>)projectVos).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
		
	}

	@Override
	public PageResult<ProjectVo> projectList(PageParam pageParam,
			ProjectReq projectReq) {
		 //分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        //当前页列表
        List<ProjectVo> projectVos = projectExtMapper.selectProjectList(projectReq);
        //构造分页结果
        this.packageProjectButton(projectVos);
        PageResult<ProjectVo> pageResult = PageResult.newPageResult(projectVos, ((Page<ProjectVo>)projectVos).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
		
	}
	
	@Override
	public PageResult<ProjectVo> detailPageList(PageParam pageParam,
			ProjectReq projectReq) {
		 //分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        //当前页列表
        List<ProjectVo> projectVos = projectExtMapper.selectDetailProjectList(projectReq);
        //构造分页结果
        PageResult<ProjectVo> pageResult = PageResult.newPageResult(projectVos, ((Page<ProjectVo>)projectVos).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
	}

	private void packageProjectButton(List<ProjectVo> projectVos){
		for(ProjectVo projectVo:projectVos){
			List<WorkFlow> workFlows = projectVo.getWorkFlows();
			for(WorkFlow workFlow : workFlows ){
				 Byte authority= workFlow.getAuthority();
				 if(AuthorityStatus.COMMIT_USER.getKey().equals(authority)){
					 if(ProjectStatus.INIT_PROJECT.getKey().equals(projectVo.getStatus())){
						 projectVo.setShowSelectProjectManager(true);
					 }else if(ProjectStatus.PROJECT_MANAGER.getKey().equals(projectVo.getStatus())){
						 projectVo.setShowSelectPriceManager(true);
					 }else{
						 projectVo.setShowDetail(true);
						
					 }
					 projectVo.setShowDelete(true);
				 }
				 if(AuthorityStatus.PROJECT_MANAGER.getKey().equals(authority)){
					 if(ProjectStatus.PROJECT_MANAGER.getKey().equals(projectVo.getStatus())){
						 projectVo.setShowSelectPriceManager(true);
					 }else{
						 projectVo.setShowProjectManager(true);
						
					 }
				 }
				 if(AuthorityStatus.PRICE_MANAGER.getKey().equals(authority)){
					 if(ProjectStatus.PRICE_MANAGER.getKey().equals(projectVo.getStatus())){
						 projectVo.setShowSelectPriceOffer(true);
						 projectVo.setShowPriceOffer(true);
					 }else if(ProjectStatus.PRICE_OFFER.getKey().equals(projectVo.getStatus())){
						 projectVo.setShowPriceOffer(true);
					 }else{
						 projectVo.setShowDetail(true);
					 }
				 }
				 if(AuthorityStatus.PRICE_OFFER.getKey().equals(authority)){
					 if(ProjectStatus.PRICE_OFFER.getKey().equals(projectVo.getStatus())){
						 projectVo.setShowPriceOffer(true);
					 }else{
						 projectVo.setShowDetail(true);
					 }
				 }
			}
		}
		
	}
	
	@Override
	public  ProjectVo  detail(Long id) {
		ProjectVo projectVo =this.getProject(id);
		if(null!=projectVo){
			projectVo.setProjectPriceList(projectPriceService.queryByProjectId(id));			
		}
		return projectVo;
	}

	@Override
	public ProjectVo getProject(Long id) {
		return ProjectConvertor.toProjectVo(getProjectById(id));
	}
	
	public Project getProjectById(Long id) {
		ProjectExample example = new ProjectExample();
		ProjectExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id).andIsDeletedEqualTo(Constants.ISNOTDELETEDBOLN);
		List<Project> projects  = projectMapper.selectByExample(example);
		if(projects.size()>0){
			return projects.get(0);
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> addOrEdit(ProjectReq projectReq) {
		Project project = ProjectConvertor.reqToProject(projectReq);
		User user = userCommonService.getUser();
		if(projectReq.getId()==null){
			project.setCommitUser(user.getName());
			project.setCommitUserId(user.getId());
			this.insert(project);
			return Result.newResult(this.insertWorkFlow(project.getId(), user.getId(), user.getId(), AuthorityStatus.COMMIT_USER,ProjectStatus.INIT_PROJECT));
		}else{
			//权限 只能修改自己有项目
			//TODO...
			project.setUpdateUser(user.getName());
			project.setUpdateUserId(user.getId());
			return Result.newResult(this.update(project));
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> delete(Long id) {
		 
		if(id==null){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		Project project = this.getProjectById(id);
		if(null==project){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PROJECT_EMPTY);
		}
	 
		if (userCommonService.getUserId().longValue()==project.getCommitUserId().longValue()){
			Project record = new Project();
			record.setId(id);
			record.setIsDeleted(Constants.ISDELETEDBOLN);
			return new Result<Integer>(projectMapper.updateByPrimaryKeySelective(record));
		}else{
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
		}
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> opt(OptReq optReq) {

		if(optReq.getId()==null||optReq.getOptType()==null||optReq.getUserId()==null){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		Project project = this.getProjectById(optReq.getId());
		if(null==project){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PROJECT_EMPTY);
		}
		User user = userCommonService.getUser();
		User appointUser = userMapper.selectByPrimaryKey(optReq.getUserId());
		switch(optReq.getOptType().byteValue()){
			case (byte)1:
				if(ProjectStatus.INIT_PROJECT.getKey().byteValue()==project.getStatus().byteValue()
				&&user.getId().longValue()==project.getCommitUserId().longValue()){
					Project updateProject = new Project();
					updateProject.setId(project.getId());
					updateProject.setStatus(ProjectStatus.PROJECT_MANAGER.getKey().byteValue());
					updateProject.setProjectManager(appointUser.getName());
					updateProject.setProjectManagerId(appointUser.getId());
					updateProject.setProjectManagerTime(new Date());
					return new Result<Integer>(this.optProject(updateProject, appointUser.getId(), user.getId(), AuthorityStatus.PROJECT_MANAGER,ProjectStatus.PROJECT_MANAGER));
				}else{
					return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
				}
			case (byte)2: 
				if(ProjectStatus.PROJECT_MANAGER.getKey().byteValue()==project.getStatus().byteValue()
				&&user.getId().longValue()==project.getProjectManagerId().longValue()){
					Project updateProject = new Project();
					updateProject.setId(project.getId());
					updateProject.setStatus(ProjectStatus.PRICE_MANAGER.getKey().byteValue());
					updateProject.setPriceManager(appointUser.getName());
					updateProject.setPriceManagerId(appointUser.getId());
					updateProject.setPriceManagerTime(new Date());
					return new Result<Integer>(this.optProject(updateProject, appointUser.getId(), user.getId(), AuthorityStatus.PRICE_MANAGER,ProjectStatus.PRICE_MANAGER));
				}else{
					return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
				}
			case (byte)3:
				if(ProjectStatus.PRICE_MANAGER.getKey().byteValue()==project.getStatus().byteValue()
				&&user.getId().longValue()==project.getPriceManagerId().longValue()){
					Project updateProject = new Project();
					updateProject.setId(project.getId());
					updateProject.setStatus(ProjectStatus.PRICE_OFFER.getKey().byteValue());
					updateProject.setPriceOffer(appointUser.getName());
					updateProject.setPriceOfferId(appointUser.getId());
					updateProject.setPriceOfferTime(new Date());
					return new Result<Integer>(this.optProject(updateProject, appointUser.getId(), user.getId(), AuthorityStatus.PRICE_OFFER,ProjectStatus.PRICE_OFFER));
				}else{
					return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
				}
			default:
				return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
 
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Integer optProject(Project project,Long appointUser,Long creator,AuthorityStatus authorityStatus,ProjectStatus projectStatus){
		 
		this.insertWorkFlow(project.getId(), appointUser, creator, authorityStatus,projectStatus);
		
		return this.update(project);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Integer insertWorkFlow(Long refId,Long appointUser,Long creator,AuthorityStatus authorityStatus,ProjectStatus projectStatus){
		WorkFlow workFlow = new WorkFlow();
		workFlow.setAuthority(authorityStatus.getKey());
		workFlow.setCreator(creator);
		workFlow.setRefId(refId);
		workFlow.setUserId(appointUser);
		workFlow.setStatus(projectStatus.getKey());
		return workFlowMapper.insertSelective(workFlow);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Integer insert(Project project){
		project.setCode(CodeFactory.getCode());
		return projectExtMapper.insertSelective(project);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Integer update(Project project){
		return projectMapper.updateByPrimaryKeySelective(project);
	}

	
	
	@Override
	public List<ScheduleVo> selectProjectSchedule(Long id) {
		List<ScheduleVo> scheduleVos = projectExtMapper.selectProjectSchedule(id);
		for(ScheduleVo scheduleVo:scheduleVos){
			scheduleVo.setAuthorityStr(ProjectStatus.getValueByKey(scheduleVo.getStatus()));
		}
		Integer priceProject = projectExtMapper.selectPriceProject(id);
		if(priceProject>0){
			ScheduleVo priceScheduleVo  = new ScheduleVo();
			priceScheduleVo.setNum(priceProject);
			priceScheduleVo.setAuthorityStr("报价中");
			scheduleVos.add(priceScheduleVo);
		}
		
		Integer managerProject = projectExtMapper.selectManagerProject(id);
		if(managerProject>0){
			ScheduleVo managerScheduleVo = new ScheduleVo();
			managerScheduleVo.setNum(managerProject);
			managerScheduleVo.setAuthorityStr("正在进行，请及时添加项目进度");
			scheduleVos.add(managerScheduleVo);
		}
			
		return scheduleVos;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> signContract(SignContractReq signContractReq) {
		if(signContractReq.getProjectId()==null||signContractReq.getSign()==null){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		Project project = this.getProjectById(signContractReq.getProjectId());
		if(null==project){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PROJECT_EMPTY);
		}
		if(project.getProjectManagerId().longValue()==userCommonService.getUserId().longValue()){
			if(project.getStatus().byteValue()==ProjectStatus.PRICE_OFFER.getKey().byteValue()){
				Project updateProject = new Project();
				updateProject.setId(signContractReq.getProjectId());
				updateProject.setReason(signContractReq.getReason());
				updateProject.setUpdateUserId(userCommonService.getUserId());
				updateProject.setStatus(signContractReq.getSign().byteValue()==1?ProjectStatus.SIGN_CONTRACT.getKey():ProjectStatus.NO_CONTRACT.getKey());
				return new Result<Integer>(this.update(updateProject));
			}else{
				return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_PRICE);
			}
			
		}else{
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
		}
		
	}

}
