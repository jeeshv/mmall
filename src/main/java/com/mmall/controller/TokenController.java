package com.mmall.controller;

import com.mmall.pojo.User;
import com.mmall.security.JWTUtil;
import com.mmall.service.impl.UserServiceImpl;
import com.mmall.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/token")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TokenController {

    @Autowired
    UserServiceImpl userService;

    @ResponseBody
    @RequestMapping(value = "/check")
    public void checkUser(@RequestHeader HttpHeaders headers) {
        String token = headers.getFirst(Consts.AUTHORIZATION);
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            /*return ResponseMessage.fail().add("error", "口令验证失败!");*/
        }
        User user = userService.isUserExists(username);
        /*return ResponseMessage.success().add("user", user).add("token", token);*/
    }

}
