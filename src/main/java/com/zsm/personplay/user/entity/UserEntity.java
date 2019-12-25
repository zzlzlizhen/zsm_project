package com.zsm.personplay.user.entity;

import java.io.Serializable;

/**
 * created by zsm on 2019/12/25
 */
class UserEntity  implements Serializable {
    private Long userId;
    private String username;
    private String pwd;
    private String token;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
