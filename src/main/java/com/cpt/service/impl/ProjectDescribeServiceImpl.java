package com.cpt.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.DescribeType;
import com.cpt.common.constant.MessageConstants;
import com.cpt.mapper.ProjectDescribeMapper;
import com.cpt.model.ProjectDescribe;
import com.cpt.model.ProjectDescribeExample;
import com.cpt.service.ProjectDescribeService;
import com.cpt.service.UserCommonService;

@Service
public class ProjectDescribeServiceImpl implements ProjectDescribeService {

	@Autowired
	private ProjectDescribeMapper projectDescribeMapper;
	@Resource
	private UserCommonService userCommonService;
	@Override
	public List<ProjectDescribe> queryDescribe(Long projectId) {
		ProjectDescribeExample example = new ProjectDescribeExample();
		ProjectDescribeExample.Criteria criteria = example.createCriteria();
		criteria.andProjectIdEqualTo(projectId);
		criteria.andTypeEqualTo(DescribeType.PROJECT_DESCRIBE.getKey());
		return projectDescribeMapper.selectByExample(example);
	}

	@Override
	public List<ProjectDescribe> queryLog(Long projectId) {
		ProjectDescribeExample example = new ProjectDescribeExample();
		ProjectDescribeExample.Criteria criteria = example.createCriteria();
		criteria.andProjectIdEqualTo(projectId);
		criteria.andTypeEqualTo(DescribeType.PROJECT_LOG.getKey());
		return projectDescribeMapper.selectByExample(example);
	}

	@Override
	public Result<ProjectDescribe> insertDescribe(ProjectDescribe projectDescribe) {
		if(projectDescribe.getProjectId()==null||StringUtils.isBlank(projectDescribe.getContent())){
			return new Result<ProjectDescribe>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		projectDescribe.setType(DescribeType.PROJECT_DESCRIBE.getKey());
		projectDescribe.setCreateUser(userCommonService.getUserId());
		projectDescribe.setCreateTime(new Date());
		projectDescribeMapper.insertSelective(projectDescribe);
		return Result.newResult(projectDescribe);
	}

	@Override
	public Result<ProjectDescribe> insertLog(ProjectDescribe projectDescribe) {
		if(projectDescribe.getProjectId()==null||StringUtils.isBlank(projectDescribe.getContent())){
			return new Result<ProjectDescribe>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		projectDescribe.setType(DescribeType.PROJECT_LOG.getKey());
		projectDescribe.setCreateUser(userCommonService.getUserId());
		projectDescribe.setCreateTime(new Date());
		projectDescribeMapper.insertSelective(projectDescribe);
		return Result.newResult(projectDescribe);
	}

}
