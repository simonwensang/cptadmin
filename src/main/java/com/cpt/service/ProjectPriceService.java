package com.cpt.service;

import java.util.List;

import com.cpt.model.ProjectPrice;

public interface ProjectPriceService {

	public List<ProjectPrice> queryByProjectId(Long projectId);
	
}
