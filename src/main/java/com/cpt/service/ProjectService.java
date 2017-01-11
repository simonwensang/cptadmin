package com.cpt.service;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.req.OptReq;
import com.cpt.req.ProjectReq;
import com.cpt.vo.ProjectVo;

public interface ProjectService {
	
	PageResult<ProjectVo> pageList(PageParam pageParam,ProjectReq projectReq);
	
	ProjectVo getProjectById(Long id);
	
	ProjectVo detail(Long id);
	
	Result<Integer> addOrEdit(ProjectReq projectReq);
	
	Result<Integer> opt( OptReq optReq);
}
