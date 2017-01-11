package com.cpt.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import com.cpt.model.User;
import com.cpt.service.UserCommonService;

@Service
public class UserCommonServiceImpl implements UserCommonService{

    public User getUser() {
    	User user = null;
        if(SecurityUtils.getSubject().isAuthenticated()){
            user = (User)SecurityUtils.getSubject().getPrincipal();
        }
        return user;
    }
    
    @Override
    public Long getUserId() {
    	User user = getUser();
        if(null != user){
           return user.getId(); 
        }
        return null;
    }

    @Override
    public String getSessionId() {
        String sessionId = null;
        Session session = SecurityUtils.getSubject().getSession();
        if( null != session){
            sessionId = session.getId().toString();
        }
        return sessionId;
    }
    
}
