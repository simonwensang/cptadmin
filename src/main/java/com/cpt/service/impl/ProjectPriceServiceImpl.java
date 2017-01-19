package com.cpt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.mapper.ProjectPriceMapper;
import com.cpt.service.ProjectPriceService;
import com.cpt.vo.ProjectPriceVo;

@Service
public class ProjectPriceServiceImpl implements ProjectPriceService {

	@Autowired
	private ProjectPriceMapper projectPriceMapper;
	
	@Override
	public List<ProjectPriceVo> queryByProjectId(Long projectId) {
		
		
		
		return null;
	}

}