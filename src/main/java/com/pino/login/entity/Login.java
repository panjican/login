package com.pino.login.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Login implements Serializable {
    /*主键ID */
    private long userId;
    /* 用户名字 */
    private String name;
    /*用户密码*/
    private String password;
    /*用户登录时间*/
    private LocalDateTime loginTime;
    /*用户注册时间*/
    private LocalDateTime createTime;

    public Login() {
    }

    public Login(long userId, String name, String password, LocalDateTime loginTime, LocalDateTime createTime) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.loginTime = loginTime;
        this.createTime = createTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", loginTime=" + loginTime +
                ", createTime=" + createTime +
                '}';
    }
}
