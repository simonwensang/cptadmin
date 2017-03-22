package com.cpt.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.MessageConstants;
import com.cpt.common.util.DateUtils;
import com.cpt.convertor.UserLogConvertor;
import com.cpt.mapper.OrganizationMapper;
import com.cpt.mapper.UserLogMapper;
import com.cpt.mapper.ext.UserLogExtMapper;
import com.cpt.model.Organization;
import com.cpt.model.OrganizationExample;
import com.cpt.model.User;
import com.cpt.model.UserLog;
import com.cpt.model.UserLogExample;
import com.cpt.service.UserCommonService;
import com.cpt.service.UserLogService;
import com.cpt.vo.UserLogVo;
import com.google.common.collect.Lists;

@Service
public class UserLogServiceImpl implements UserLogService {
	@Autowired
	private UserLogMapper userLogMapper;
	@Autowired
	private UserLogExtMapper userLogExtMapper;
	@Autowired
	private UserCommonService userCommonService;
	@Autowired
	private OrganizationMapper organizationMapper;
	@Override
	public Result<UserLogVo> query(String logTime) {
		UserLogVo userLogVo = new UserLogVo();
		UserLogExample example = new UserLogExample();
		UserLogExample.Criteria criteria =example.createCriteria();
		criteria.andLogTimeEqualTo(logTime);
		criteria.andUserIdEqualTo(userCommonService.getUserId());
		List<UserLog> log = userLogMapper.selectByExample(example);
		if(log.size()>0){
			userLogVo = UserLogConvertor.toUserLogVo(log.get(0));
		}
 
		User user = userCommonService.getUser();
		OrganizationExample exampleOrg=new OrganizationExample();
		OrganizationExample.Criteria criteriaOrg = exampleOrg.createCriteria()  ;
		criteriaOrg.andParentIdEqualTo(user.getDepartmentId());
		List<Organization> organizations = organizationMapper.selectByExample(exampleOrg);
		 
		List<UserLog> departmentLogs= Lists.newArrayList();
		if(organizations.size()>0){
			List<Long> ids = Lists.newArrayList();
			for (Organization organization : organizations){
				ids.add(organization.getId());
			}
			departmentLogs= userLogExtMapper.selectListDepartment(logTime,ids);
		}
		userLogVo.setDepartmentLogs( departmentLogs);
		return Result.newResult(userLogVo);
	}

	@Override
	public Result<Integer> addOrEdit(UserLog userLog) {
		if(StringUtils.isBlank(userLog.getContent())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		UserLogExample example = new UserLogExample();
		UserLogExample.Criteria criteria =example.createCriteria();
		criteria.andLogTimeEqualTo(DateUtils.format(new Date(), DateUtils.dateString));
		criteria.andUserIdEqualTo(userCommonService.getUserId());
		List<UserLog> log = userLogMapper.selectByExample(example);
		
		if(log.size()==0){
			userLog.setUser(userCommonService.getUser().getName());
			userLog.setUserId(userCommonService.getUserId());
			userLog.setLogTime(DateUtils.format(new Date(), DateUtils.dateString));
			return Result.newResult(this.insert(userLog));
		}else{
			/*UserLog old = this.get(userLog.getId());
			if(!old.getUserId().equals(userCommonService.getUserId())){
				return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
			}*/
			userLog.setId(log.get(0).getId());
			return Result.newResult(this.update(userLog));
		}
	}

	@Override
	public UserLog get(Long id) {
		return userLogMapper.selectByPrimaryKey(id);
	}
	private int insert(UserLog userLog){
		return userLogMapper.insertSelective(userLog);
	}

	private int update(UserLog userLog){
		return userLogMapper.updateByPrimaryKeySelective(userLog);
	}
}
