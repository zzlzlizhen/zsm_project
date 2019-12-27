package com.zsm.personplay.user.controller;

import com.zsm.personplay.common.RetCode;
import com.zsm.personplay.common.RetResult;
import com.zsm.personplay.user.entity.UserEntity;
import com.zsm.personplay.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * created by zsm on 2019/12/25
 * 解决跨域问题
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public RetResult getLogin(@RequestBody UserEntity userEntity){
        UserEntity userent = userService.login(userEntity);
        return new RetResult(RetCode.SUCCESS.getCode(),userent);
    }
}

