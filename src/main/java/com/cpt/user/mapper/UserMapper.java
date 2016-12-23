package com.cpt.user.mapper;

import org.apache.ibatis.annotations.Select;

import com.cpt.user.entity.User;

public interface UserMapper {

	@Select("select * from t_user where id=#{id}")
	public User selectByPrimaryKey(Long id);
	
}
