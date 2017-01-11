package com.cpt.service.impl;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.mapper.UserMapper;
import com.cpt.model.User;
import com.cpt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper ;
	
	@Override
	public User get() {
		
		return userMapper.selectByPrimaryKey(1L);
	}

}
