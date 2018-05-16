package com.pino.login.enums;

public enum LoginStatEnum {
    SUCCESS(1, "添加成功"),
    FAIL(0, "添加失败"),
    PASS(2, "验证通过"),
    WRONG(3, "验证失败");


    private int state;
    private String info;

    LoginStatEnum() {
    }

    LoginStatEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    public static LoginStatEnum stateOf(int index) {
        for (LoginStatEnum statEnum : values()) {
            if (statEnum.getState() == index) {
                return statEnum;
            }
        }
        return null;
    }
}
