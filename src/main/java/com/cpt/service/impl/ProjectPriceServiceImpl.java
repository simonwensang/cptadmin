package com.cpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.MessageConstants;
import com.cpt.convertor.ProjectPriceConvertor;
import com.cpt.mapper.CustomerMapper;
import com.cpt.mapper.ProjectMapper;
import com.cpt.mapper.ProjectPriceItemMapper;
import com.cpt.mapper.ProjectPriceMapper;
import com.cpt.mapper.ext.ProjectPriceExtMapper;
import com.cpt.mapper.ext.ProjectPriceItemExtMapper;
import com.cpt.model.Customer;
import com.cpt.model.Project;
import com.cpt.model.ProjectPrice;
import com.cpt.model.ProjectPriceItem;
import com.cpt.model.ProjectPriceItemExample;
import com.cpt.req.PriceDeleteReq;
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
	private ProjectPriceItemMapper projectPriceItemMapper;
	@Resource
	private ProjectMapper projectMapper;
	
	@Resource
	private  CustomerMapper customerMapper;
	
	@Override
	public List<ProjectPriceVo> queryByProjectId(Long projectId) {
		
		return projectPriceExtMapper.selectByProjectId(projectId);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> insert(ProjectPriceVo projectPriceVo) {
 
		if(projectPriceVo.getProjectId()==null||projectPriceVo.getCompanyId()==null ||StringUtils.isBlank(projectPriceVo.getManager())||StringUtils.isBlank(projectPriceVo.getTel())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_EMPTY);
		}
		List<ProjectPriceItem> projectPriceItems= projectPriceVo.getProjectPriceItems();
		if(projectPriceItems!=null){
			for (ProjectPriceItem projectPriceItem:projectPriceItems) {
				if(projectPriceItem.getPrice()==null||projectPriceItem.getRatio()==null){
					return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_EMPTY);
				}
			}
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
		Customer customer = customerMapper.selectByPrimaryKey(projectPrice.getCompanyId());
		if(null==customer){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.CUSTOMER_EMPTY);
		}
		projectPrice.setCompany(customer.getName());
		projectPriceExtMapper.insertSelective(projectPrice);
		if(projectPriceItems!=null){
			for (ProjectPriceItem projectPriceItem:projectPriceItems) {
				projectPriceItem.setPriceId(projectPrice.getId());
				projectPriceItem.setCreateUserId(userCommonService.getUserId());
			}
			projectPriceItemExtMapper.insertList(projectPriceItems);
		}
		return Result.newResult(1);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> delete(PriceDeleteReq req) {
		Project project = projectMapper.selectByPrimaryKey(req.getProjectId());
		if(null==project){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PROJECT_EMPTY);
		}
		Long userId = userCommonService.getUserId();
		if(!userId.equals(project.getPriceManagerId())&&!userId.equals(project.getPriceOfferId())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
		}
		projectPriceMapper.deleteByPrimaryKey(req.getId());
		ProjectPriceItemExample  example = new ProjectPriceItemExample();
		ProjectPriceItemExample.Criteria criteria = example.createCriteria();
		criteria.andPriceIdEqualTo(req.getId());
		return Result.newResult(projectPriceItemMapper.deleteByExample(example));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> deleteItem(PriceDeleteReq req) {
		Project project = projectMapper.selectByPrimaryKey(req.getProjectId());
		if(null==project){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PROJECT_EMPTY);
		}
		Long userId = userCommonService.getUserId();
		if(!userId.equals(project.getPriceManagerId())&&!userId.equals(project.getPriceOfferId())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
		}
		return Result.newResult(projectPriceItemMapper.deleteByPrimaryKey(req.getId()));
	}

	@Override
	public Result<Integer> savePriceOfferItem(ProjectPriceItem projectPriceItem) {
		Project project = projectMapper.selectByPrimaryKey(projectPriceItem.getProjectId());
		if(null==project){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PROJECT_EMPTY);
		}
		Long userId = userCommonService.getUserId();
		if(!userId.equals(project.getPriceManagerId())&&!userId.equals(project.getPriceOfferId())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
		}
		projectPriceItem.setCreateUserId(userId);
		return Result.newResult(projectPriceItemMapper.insertSelective(projectPriceItem));
	}
	
}
