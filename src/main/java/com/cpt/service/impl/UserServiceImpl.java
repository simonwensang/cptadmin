package com.cpt.service.impl;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.common.constant.Constants;
import com.cpt.common.constant.UserIdentity;
import com.cpt.convertor.UserConvertor;
import com.cpt.mapper.UserMapper;
import com.cpt.mapper.ext.UserExtMapper;
import com.cpt.model.User;
import com.cpt.model.UserExample;
import com.cpt.req.UserQuery;
import com.cpt.service.UserService;
import com.cpt.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper ;
	@Autowired
	private UserExtMapper userExtMapper ;
	@Override
	public User get() {
		
		return userMapper.selectByPrimaryKey(1L);
	}

	@Override
	public List<User> query(UserQuery userQuery) {
		
		return userExtMapper.query(userQuery);
	}

	@Override
	public List<UserVo> queryPriceOffer() {
		
		UserExample userExample =new UserExample();
		UserExample.Criteria criteria =userExample.createCriteria();
		criteria.andIdentityEqualTo(UserIdentity.PRICE_OFFER.getKey());
		criteria.andIsDeletedEqualTo(Constants.ISNOTDELETED);
		return UserConvertor.toUserVoList(userMapper.selectByExample(userExample));
	}
 
}
