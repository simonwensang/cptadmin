package com.cpt.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

import com.cpt.model.UserLog;

@Data
public class UserLogVo {
	private Long id;

    private String user;

    private Long userId;

    private String logTime;

    private Date createTime;

    private String content;
    
    private List<UserLog> departmentLogs;
}
