package com.cpt.service;

import com.cpt.common.Result;
import com.cpt.model.UserLog;
import com.cpt.vo.UserLogVo;

public interface UserLogService {
	
	public  Result<UserLogVo> query(String logTime);
	
	public Result<Integer> addOrEdit(UserLog userLog) ;
	
	public UserLog get(Long id);
}
