package com.cpt.service;

 
import java.util.List;

import com.cpt.model.User;
import com.cpt.req.UserQuery;
import com.cpt.vo.UserVo;

public interface UserService {

	public User get();
 	
	public List<User> query(UserQuery userQuery);
	
	List<UserVo> queryPriceOffer();
	
}
