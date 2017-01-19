package com.cpt.vo;

import java.util.Date;

import lombok.Data;

@Data
public class UserVo {
 
	private Long id;

    private String account;

    private String name;

    private Date createTime;

    private String department;

    private Long departmentId;

    private String mobile;

    private String image;

    private Byte identity;

    private Byte isDeleted;
 
}
