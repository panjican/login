package com.pino.login.dto;

import com.pino.login.entity.Login;
import com.pino.login.enums.LoginStatEnum;

public class LoginExecution {

    /* 添加用户结果的状态 */
    private int state;
    /* 状态的明文标示 */
    private String stateInfo;

    private Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public int getState() {
        return state;
    }

    public LoginExecution(LoginStatEnum statEnum) {
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
    }
    public LoginExecution(LoginStatEnum statEnum, Login login) {
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
        this.login = login;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {
        return "LoginExecution{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", login=" + login +
                '}';
    }
}
