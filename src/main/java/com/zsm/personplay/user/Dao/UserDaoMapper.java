package com.zsm.personplay.user.Dao;

import com.zsm.personplay.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * created by zsm on 2019/12/25
 */
@Mapper
public interface UserDaoMapper {
    UserEntity login(@Param("username")String username, @Param("pwd")String pwd);
}
