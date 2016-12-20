package com.cpt.user.mapper;

import org.apache.ibatis.annotations.Select;

import com.cpt.user.entity.User;

public interface UserMapper {
	@Select("select * from t_user where id=#{id}")
	User select(Long id);
	
   /* int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);*/
}