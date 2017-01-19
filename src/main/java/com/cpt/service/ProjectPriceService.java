package com.cpt.service;

import java.util.List;

import com.cpt.vo.ProjectPriceVo;

public interface ProjectPriceService {

	public List<ProjectPriceVo> queryByProjectId(Long projectId);
	
}
