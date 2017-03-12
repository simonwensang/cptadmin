package com.cpt.service;

import java.util.List;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.req.OptReq;
import com.cpt.req.ProjectReq;
import com.cpt.req.SignContractReq;
import com.cpt.vo.ProjectVo;
import com.cpt.vo.ScheduleVo;

public interface ProjectService {
	
	PageResult<ProjectVo> pageList(PageParam pageParam,ProjectReq projectReq);
	
	PageResult<ProjectVo>  projectList(PageParam pageParam,ProjectReq projectReq);
	
	PageResult<ProjectVo> detailPageList(PageParam pageParam,ProjectReq projectReq);
	
	ProjectVo getProject(Long id);
	
	ProjectVo detail(Long id);
	
	Result<Integer> addOrEdit(ProjectReq projectReq);
	
	Result<Integer> delete(Long id);
	
	Result<Integer> opt( OptReq optReq);
	
	Result<Integer> signContract( SignContractReq signContractReq);
	
	List<ScheduleVo> selectProjectSchedule(Long id);
}
