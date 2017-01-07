package com.cpt.user.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.user.entity.User;
import com.cpt.user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper ;
	
	@Override
	public User get() {
		
		return userMapper.selectByPrimaryKey(1);
	}

}
