package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.UserLog;

public interface UserLogExtMapper {
    
    List<UserLog> selectListDepartment(List<Long> list);
 
}