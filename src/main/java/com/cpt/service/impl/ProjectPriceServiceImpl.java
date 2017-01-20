package com.cpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.MessageConstants;
import com.cpt.convertor.ProjectPriceConvertor;
import com.cpt.mapper.ProjectMapper;
import com.cpt.mapper.ProjectPriceMapper;
import com.cpt.mapper.ext.ProjectPriceExtMapper;
import com.cpt.mapper.ext.ProjectPriceItemExtMapper;
import com.cpt.model.Project;
import com.cpt.model.ProjectPrice;
import com.cpt.model.ProjectPriceItem;
import com.cpt.service.ProjectPriceService;
import com.cpt.service.UserCommonService;
import com.cpt.vo.ProjectPriceVo;

@Service
public class ProjectPriceServiceImpl implements ProjectPriceService {

	@Autowired
	private ProjectPriceMapper projectPriceMapper;
	
	@Autowired
	private ProjectPriceExtMapper projectPriceExtMapper;
	
	@Resource
	private UserCommonService userCommonService;
	
	@Resource
	private ProjectPriceItemExtMapper projectPriceItemExtMapper;
	
	@Resource
	private ProjectMapper projectMapper;
	
	@Override
	public List<ProjectPriceVo> queryByProjectId(Long projectId) {
		
		return projectPriceExtMapper.selectByProjectId(projectId);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> insert(ProjectPriceVo projectPriceVo) {

		if(projectPriceVo.getProjectId()==null||projectPriceVo.getCompanyId()==null){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		Project project = projectMapper.selectByPrimaryKey(projectPriceVo.getProjectId());
		if(null==project){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PROJECT_EMPTY);
		}
		Long userId = userCommonService.getUserId();
		
		if(!userId.equals(project.getPriceManagerId())&&!userId.equals(project.getPriceOfferId())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
		}
		
		ProjectPrice projectPrice = ProjectPriceConvertor.toProjectPrice(projectPriceVo);
		
		projectPriceExtMapper.insertSelective(projectPrice);
		
		List<ProjectPriceItem> projectPriceItems= projectPriceVo.getProjectPriceItems();
		
		for (ProjectPriceItem projectPriceItem:projectPriceItems) {
			projectPriceItem.setPriceId(projectPrice.getId());
			projectPriceItem.setCreateUserId(userCommonService.getUserId());
		}
		
		return Result.newResult( projectPriceItemExtMapper.insertList(projectPriceItems));
	}

}