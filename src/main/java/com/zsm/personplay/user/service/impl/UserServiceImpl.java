package com.zsm.personplay.user.service.impl;

import com.zsm.personplay.user.Dao.UserDaoMapper;
import com.zsm.personplay.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by zsm on 2019/12/25
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDaoMapper userDaoMapper;

    @Override
    public String login(String username, String pwd) {
        return userDaoMapper.login(username,pwd);
    }
}
