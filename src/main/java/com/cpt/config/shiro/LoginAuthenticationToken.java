package com.cpt.config.shiro;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.shiro.authc.UsernamePasswordToken;

@Data
@EqualsAndHashCode(callSuper=false)
public class LoginAuthenticationToken extends UsernamePasswordToken{
	private static final long serialVersionUID = -6190089497623075624L;
	private String code = null;                 // 手机验证码
	
    public LoginAuthenticationToken(String userName, String password, boolean rememberMe) {
        super(userName, password, rememberMe);
    }
}