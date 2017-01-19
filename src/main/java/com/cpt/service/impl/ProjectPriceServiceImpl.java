package com.cpt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.mapper.ProjectPriceMapper;
import com.cpt.model.ProjectPrice;
import com.cpt.service.ProjectPriceService;

@Service
public class ProjectPriceServiceImpl implements ProjectPriceService {

	@Autowired
	private ProjectPriceMapper projectPriceMapper;
	
	@Override
	public List<ProjectPrice> queryByProjectId(Long projectId) {
		
		
		
		return null;
	}

}