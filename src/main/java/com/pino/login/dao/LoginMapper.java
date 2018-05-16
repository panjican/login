package com.pino.login.dao;

import com.pino.login.entity.Login;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

public interface LoginMapper {
    /**
     *
     * @param name
     * @param password
     * @return
     */
    int  register(@Param("name") String name, @Param("password") String password, @Param("loginTime") LocalDateTime loginTime, @Param("createTime") LocalDateTime createTime);

    /**
     *
     * @param name
     * @param password
     * @return
     */
    Login login(@Param("name") String name, @Param("password") String password);

}
