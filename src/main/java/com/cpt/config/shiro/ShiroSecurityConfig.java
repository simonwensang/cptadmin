package com.cpt.config.shiro;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.filter.DelegatingFilterProxy;


@Configuration
public class ShiroSecurityConfig {
	/**
	 * FilterRegistrationBean
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter")); 
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*"); 
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistration;
	}
	
	/**
	 * @see org.apache.shiro.spring.web.ShiroFilterFactoryBean
	 * @return
	 */
	@Bean(name = "shiroFilter")
	    public ShiroFilterFactoryBean shiroFilter(){
	        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
	        shiroFilter.setSecurityManager(securityManager());
	        shiroFilter.setLoginUrl("/login");
	        shiroFilter.setUnauthorizedUrl("/unauthor");
	        
	        Map<String, Filter> filters = new HashMap<>();
	       // filters.put("kickout", kickoutSessionControlFilter());
//	      filters.put("authc", wswyAuthenticationFilter());
	        filters.put("anon", new AnonymousFilter());
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
	
	/**
	 * @see org.apache.shiro.mgt.SecurityManager
	 * @return
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(customSecurityRealm());
		manager.setCacheManager(redisCacheManager());
		manager.setSessionManager(defaultWebSessionManager());
		return manager;
	}
	
	/**
	 * @see DefaultWebSessionManager
	 * @return
	 */
	@Bean(name="sessionManager")
	public DefaultWebSessionManager defaultWebSessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setCacheManager(redisCacheManager());
		sessionManager.setGlobalSessionTimeout(1800000);
		sessionManager.setDeleteInvalidSessions(true);
		sessionManager.setSessionValidationSchedulerEnabled(true);
		sessionManager.setDeleteInvalidSessions(true);
		return sessionManager;
	}
   
    @Bean
    @DependsOn(value={"lifecycleBeanPostProcessor", "shrioRedisCacheManager"})
    public CustomSecurityRealm customSecurityRealm(){
    	CustomSecurityRealm userRealm = new CustomSecurityRealm();
    	userRealm.setCacheManager(redisCacheManager());
    	userRealm.setCachingEnabled(true);
		userRealm.setAuthenticationCachingEnabled(true);
		userRealm.setAuthorizationCachingEnabled(true);
    	return userRealm;
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
    
    @Bean(name="shrioRedisCacheManager")
	@DependsOn(value="redisTemplate")
	public ShrioRedisCacheManager redisCacheManager() {
		ShrioRedisCacheManager cacheManager = new ShrioRedisCacheManager(redisTemplate());
		return cacheManager;
	}
	
	@Bean(name="redisTemplate")
	public RedisTemplate<byte[], Object> redisTemplate() {
	    RedisTemplate<byte[], Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(connectionFactory());
	    return template;
	}
	
	@Bean
	public JedisConnectionFactory connectionFactory(){
		JedisConnectionFactory conn = new JedisConnectionFactory();
		conn.setDatabase(3);
		conn.setHostName("127.0.0.1");
		//conn.setPassword("123456");
		conn.setPort(6379);
		conn.setTimeout(3000);
		return conn;
	}
    
    /**
     * 保证实现了Shiro内部lifecycle函数的bean执行
     * @return
     */
    @Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
}