package com.cpt.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpt.model.UserLog;

public interface UserLogExtMapper {
    
    List<UserLog> selectListDepartment(@Param("logTime") String logTime, @Param("list")  List<Long> list);
    
}