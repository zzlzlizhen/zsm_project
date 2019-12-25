package com.zsm.personplay.user.controller;

import com.zsm.personplay.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by zsm on 2019/12/25
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLogin(String username,String pwd){
        String token = userService.login(username,pwd);
        return token;
    }
}
