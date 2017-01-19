package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.User;
import com.cpt.req.UserQuery;

public interface UserExtMapper {
    
    List<User> query(UserQuery userQuery);
}