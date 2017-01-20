package com.cpt.service;

import java.util.List;

import com.cpt.common.Result;
import com.cpt.vo.ProjectPriceVo;

public interface ProjectPriceService {

	public List<ProjectPriceVo> queryByProjectId(Long projectId);
	
	public Result<Integer> insert(ProjectPriceVo projectPriceVo);
	
}
