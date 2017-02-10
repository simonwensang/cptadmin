package com.cpt.convertor;


import org.springframework.cglib.beans.BeanCopier;

import com.cpt.model.UserLog;
import com.cpt.vo.UserLogVo;

public class UserLogConvertor {
	
    private static final BeanCopier beanCopierForUserLogVo = BeanCopier.create(UserLog.class,UserLogVo.class,false);
    
    public static UserLogVo toUserLogVo(UserLog userLog) {
        if (userLog == null) {
            return null;
        }
        UserLogVo userLogVo = new UserLogVo();
        beanCopierForUserLogVo.copy(userLog, userLogVo, null);
        return userLogVo;
    }

}
