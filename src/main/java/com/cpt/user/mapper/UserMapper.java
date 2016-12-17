package com.cpt.user.mapper;
 
import org.apache.ibatis.annotations.Select;

import com.cpt.user.entity.User;

public interface UserMapper {

	@Select(" select * from t_user limit 1 ") 
	public User get();
	
}
