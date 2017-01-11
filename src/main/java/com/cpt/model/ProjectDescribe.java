package com.cpt.model;

import java.util.Date;

public class ProjectDescribe {
    private Long id;

    private Long projectId;

    private Date createTime;

    private Long createUser;

    private Byte type;

    private byte[] describe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public byte[] getDescribe() {
        return describe;
    }

    public void setDescribe(byte[] describe) {
        this.describe = describe;
    }
}