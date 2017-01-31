package com.cpt.service;

import java.util.List;

import com.cpt.common.Result;
import com.cpt.model.ProjectDescribe;

public interface ProjectDescribeService {

	public List<ProjectDescribe> queryDescribe(Long projectId);
	
	public List<ProjectDescribe> queryLog(Long projectId);
	
	public Result<ProjectDescribe> insertDescribe(ProjectDescribe projectDescribe);
	
	public Result<ProjectDescribe> insertLog(ProjectDescribe projectDescribe);
	
}
