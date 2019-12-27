package com.zsm.personplay.user.service.impl;

import com.zsm.personplay.user.Dao.UserDaoMapper;
import com.zsm.personplay.user.entity.UserEntity;
import com.zsm.personplay.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * created by zsm on 2019/12/25
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDaoMapper userDaoMapper;

    @Override
    public UserEntity login(UserEntity userEntity) {
        return userDaoMapper.login(userEntity.getUsername(),userEntity.getPwd());
    }
}
