package com.mmall.controller;

import com.mmall.pojo.User;
import com.mmall.security.JWTUtil;
import com.mmall.service.impl.UserServiceImpl;
import com.mmall.util.Consts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class ControllerTools {

    @Autowired
    UserServiceImpl userServiceImpl;

    /**
     * 从header头中获得用户信息
     *
     * @param headers
     * @return
     */
    public User getUser(HttpHeaders headers) {
        String token = headers.getFirst(Consts.AUTHORIZATION);
        if(StringUtils.isEmpty(token)) return null;
        String username = JWTUtil.getUsername(token);
        return userServiceImpl.isUserExists(username);
    }
}
