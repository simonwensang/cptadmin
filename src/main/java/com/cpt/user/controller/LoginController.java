package com.cpt.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cpt.user.entity.User;

@Controller
public class LoginController {

	private static final Logger log =  LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping({"/",""})
	public String login(ModelMap map){
		return "login";
	}
	
    @RequestMapping(value = "unlogin")
    public String unlogin() {
        return "redirect:/login";
    }

    @RequestMapping(value = "/toLogin", method = RequestMethod.POST)
    public String toLogin(User user) {
    	
    	//logger.debug("Processing trade with id: {} and symbol : {} ", id, symbol);
    	log.info("toLogin");
    	UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassWord());
        token.setRememberMe(true);
        try {
        	SecurityUtils.getSubject().login(token);
        	return "redirect:/main";
        }catch (AuthenticationException e) {
        	log.error("登录失败错误信息:"+e);
        	token.clear();
        	return "redirect:/login";
        }
    }
    
    @RequestMapping(value="/logout",method=RequestMethod.GET)    
    public String logout(){   
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息  
        SecurityUtils.getSubject().logout();     
        return "redirect:/login";  
    } 
    
    public static String getRealIp(HttpServletRequest req) {
        String ip = req.getHeader("X-Real-IP");
        if (ip != null) {
            if (ip.indexOf(',') == -1) {
                return ip;
            }
            return ip.split(",")[0];
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getRemoteAddr();
        }

        return ip;
    }
}
