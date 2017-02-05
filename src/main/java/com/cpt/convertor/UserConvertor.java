package com.cpt.convertor;


import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.cpt.model.User;
import com.cpt.vo.UserVo;
import com.google.common.collect.Lists;

public class UserConvertor {
	
    private static final BeanCopier beanCopierForUser = BeanCopier.create(User.class,UserVo.class,false);
    
    private static final BeanCopier beanCopierForVoToUser = BeanCopier.create(UserVo.class,User.class,false);
    
    
    public static UserVo toUserVo(User  user) {
        if (user == null) {
            return null;
        }
        UserVo userVo = new UserVo();
        beanCopierForUser.copy(user, userVo, null);
        return userVo;
    }
    public static User reqToUser(UserVo  userVo) {
        if (userVo == null) {
            return null;
        }
        User user = new User();
        beanCopierForVoToUser.copy(userVo, user, null);
        return user;
    }
    
    public static List<UserVo> toUserVoList(List<User>  users) {
        if (users == null) {
            return null;
        }
        List<UserVo> userVoList = Lists.newArrayList();
        for(User user:users){
        	userVoList.add(toUserVo(user));
        }
        return userVoList;
    }
}
