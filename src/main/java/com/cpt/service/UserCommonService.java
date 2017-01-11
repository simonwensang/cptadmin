package com.cpt.service;

import com.cpt.model.User;

public interface UserCommonService {
    
    /**
     * 获取当前登录用户entity
     */
    public User getUser();
    
    /**
     * 获取当前登录用户id
     */
    public Long getUserId();
    
    /**
     * 获取当前SesssionId
     */
    public String getSessionId();
    
}
