package com.cpt.config.shiro;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cpt.user.entity.User;
import com.cpt.user.entity.UserExample;
import com.cpt.user.mapper.UserMapper;

@Component("customSecurityRealm")
public class CustomSecurityRealm extends AuthorizingRealm {
//	private static final Logger logger = LogManager.getLogger(AuthorizingRealm.class);
	@Resource
	private CacheManager shiroCacheManager;
	
	@Autowired
	private UserMapper userMapper;

	public CustomSecurityRealm() {
		setName("cptWswyShiroDbRealm");
		
		// 认证
//		super.setAuthenticationCacheName(Constants.AUTHENTICATIONCACHENAME);
//		super.setAuthenticationCachingEnabled(false);

		// 授权
//		super.setAuthorizationCacheName(Constants.AUTHORIZATIONCACHENAME);
	}

	/**
	 * 为当前登录的Subject授予角色和权限
	 * 
	 * @see 经测试:本例中该方法的调用时机为需授权资源被访问时
	 * @see 经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例未启用AuthorizationCache
	 * @see web层可以有shiro的缓存，dao层可以配有hibernate的缓存（后面介绍）
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
	
	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		
		//UsernamePasswordToken对象用来存放提交的登录信息  
        UsernamePasswordToken token=(UsernamePasswordToken) authcToken;
        UserExample example= new UserExample();
        UserExample.Criteria  criteria= example.createCriteria();
        criteria.andUserNameEqualTo(token.getUsername());
        List<User>  userEntityList = userMapper.selectByExample(example);
        
        if ( userEntityList.size()>0) {
        	//SecurityUtils.getSubject().getSession().setAttribute("user", userEntity);
        	return new SimpleAuthenticationInfo(userEntityList.get(0), userEntityList.get(0).getPassWord(), getName());
        } else {
        	throw new AuthenticationException("用户不存在");
        }
	}
	
	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
//        setCredentialsMatcher(new CustomCredentialsMatcher());
    }  
}
