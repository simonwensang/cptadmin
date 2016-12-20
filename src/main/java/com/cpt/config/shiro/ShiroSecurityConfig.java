package com.cpt.config.shiro;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cpt.user.mapper.UserMapper;


@Configuration
public class ShiroSecurityConfig {
	@Value("${redis.ip}")
	private String redisIp;

	@Value("${redis.port}")
	private int redisPort;

	@Value("${redis.expire}")
	private int redisExpire;
	
	@Value("${redis.timeout}")
	private int redisTimeout;
	
	@Value("${shiro.session.timeout}")
	private int shiroSessionTimeout;
	
	@Value("${shiro.session.maxcount}")
	private int shiroSessionMaxcount;

	@Value("${shiro.kickout.url}")
	private String shiroSessionKickoutUrl;
	
	@Value("${shiro.login.url}")
	private String shiroLoginUrl;
	
	@Value("${shiro.unlogin.url}")
	private String shiroUnLoginUrl;
	
	@Value("${shiro.unauthorized.url}")
	private String shiroUnauthorizedUrl;
	
    @Bean
    public RedisManager redisManager(){
    	RedisManager redisManager = new RedisManager();
    	redisManager.setHost(redisIp);
    	redisManager.setPort(redisPort);
    	redisManager.setExpire(redisExpire);
    	redisManager.setTimeout(redisTimeout);
    	return redisManager;
    }

    @Bean
    public RedisCacheManager redisCacheManager(){
    	RedisCacheManager rcm =  new RedisCacheManager();
    	rcm.setRedisManager(redisManager());
    	return rcm;
    }
    
    @Bean
    public RedisSessionDAO redisSessionDAO(){
    	RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
    	redisSessionDAO.setKeyPrefix("cpt_shiro_redis_session:");
    	redisSessionDAO.setRedisManager(redisManager());
    	return redisSessionDAO;
    }
    
    @Bean
    public CustomSecurityRealm customSecurityRealm(){
    	return new CustomSecurityRealm();
    }
    
    @Bean
    public WebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customSecurityRealm());
        securityManager.setSessionManager(sessionManager());
        securityManager.setCacheManager(redisCacheManager());
        return securityManager;
    }

    @Bean
    public SessionManager sessionManager(){
    	DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
    	defaultWebSessionManager.setGlobalSessionTimeout(shiroSessionTimeout);
    	defaultWebSessionManager.setSessionDAO(redisSessionDAO());
    	defaultWebSessionManager.setSessionValidationSchedulerEnabled(true);
    	return defaultWebSessionManager;
    }
    
    @Bean
//    @DependsOn(value="lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }
 
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }
    
    /**
     * 保证实现了Shiro内部lifecycle函数的bean执行
     * @return
     */
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
//    	return new LifecycleBeanPostProcessor();
//    }
    
    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(){
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        methodInvokingFactoryBean.setArguments(new Object[]{securityManager()});
        return methodInvokingFactoryBean;
    }
    
    @Bean
    public KickoutSessionControlFilter kickoutSessionControlFilter(){
    	KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
    	kickoutSessionControlFilter.setCacheManager(redisCacheManager());
    	kickoutSessionControlFilter.setSessionManager(sessionManager());
    	kickoutSessionControlFilter.setKickoutAfter(false);
    	kickoutSessionControlFilter.setMaxSession(shiroSessionMaxcount);
    	kickoutSessionControlFilter.setKickoutUrl(shiroSessionKickoutUrl);
    	return kickoutSessionControlFilter;
    }
    
    
    @Bean
    public ShiroFilterFactoryBean shiroFilter(){
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager());
        shiroFilter.setLoginUrl(shiroUnLoginUrl);
        shiroFilter.setUnauthorizedUrl(shiroUnauthorizedUrl);
        
        Map<String, Filter> filters = new HashMap<>();
        filters.put("kickout", kickoutSessionControlFilter());
//      filters.put("authc", wswyAuthenticationFilter());
        shiroFilter.setFilters(filters);
        
        Map<String, String> definitionsMap = new HashMap<>();
        
        definitionsMap.put("/login", "anon");//anon
        definitionsMap.put("/unlogin", "anon");//anon
        definitionsMap.put("/toLogin", "anon");//anon
        //definitionsMap.put("/**", "authc");//authc
        definitionsMap.put("/", "anon");//anon
       
        shiroFilter.setFilterChainDefinitionMap(definitionsMap);
        return shiroFilter;
    }
    
}