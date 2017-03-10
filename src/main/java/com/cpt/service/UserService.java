package com.cpt.service;

 
import java.util.List;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.model.User;
import com.cpt.req.UserQuery;
import com.cpt.vo.UserVo;

public interface UserService {

	public User get(Long id);
 	
	public PageResult<User> query(PageParam pageParam,UserQuery userQuery);
	
	List<UserVo> queryPriceOffer();
	
	public PageResult<User> pageList(PageParam pageParam, UserQuery userQuery);
	
	public Result<Integer> addOrEdit(User user);
	
	public Result<Integer> opt(UserVo userReq) ;
	
	public User getUser();
	
	public Result<Integer> exist(String name);
	
}
