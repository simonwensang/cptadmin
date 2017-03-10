package com.cpt.config.shiro;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.crazycake.shiro.RedisCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.service.UserCommonService;
  
 
/** 
 * @author Dylan 
 * @time 2014年1月8日 
 */  
@Service
public class ShiroAuthorizationHelper {  
  
	@Autowired 
    private  RedisCacheManager cacheManager;  
	@Resource
	private UserCommonService userCommonService;
	
    private  Logger log = LoggerFactory.getLogger(ShiroAuthorizationHelper.class);  
      
      
    /** 
     * 清除用户的授权信息 
     * @param username 
     */  
    public  void clearAuthorizationInfo(String username){  
        if(log.isDebugEnabled()){  
            log.debug("clear the " + username + " authorizationInfo");  
        }  
        //ShiroCasRealm.authorizationCache 为shiro自义cache名(shiroCasRealm为我们定义的reaml类的类名)  
        Cache<Object, Object> cache = cacheManager.getCache("customSecurityRealm.authorizationCache");  
        cache.remove(username);  
    }  
      
    /** 
     * 清除当前用户的授权信息 
     */  
    public  void clearAuthorizationInfo(){  
        if(SecurityUtils.getSubject().isAuthenticated()){  
            clearAuthorizationInfo(userCommonService.getUser().getAccount().toLowerCase());  
        }  
    }  
      
    /**清除session(认证信息) 
     * @param JSESSIONID 
     */  
    public  void clearAuthenticationInfo(Serializable JSESSIONID){  
        if(log.isDebugEnabled()){  
            log.debug("clear the session " + JSESSIONID);  
        }  
        //shiro-activeSessionCache 为shiro自义cache名，该名在org.apache.shiro.session.mgt.eis.CachingSessionDAO抽象类中定义  
        //如果要改变此名，可以将名称注入到sessionDao中，例如注入到CachingSessionDAO的子类EnterpriseCacheSessionDAO类中  
        Cache<Object, Object> cache = cacheManager.getCache("shiro-activeSessionCache");  
        cache.remove(JSESSIONID);  
    }

	public RedisCacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(RedisCacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}  
      
}  
