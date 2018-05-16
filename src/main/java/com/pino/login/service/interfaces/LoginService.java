package com.pino.login.service.interfaces;

import com.pino.login.dto.LoginExecution;
import com.pino.login.entity.Login;
import com.pino.login.exception.LoginException;
import com.pino.login.exception.RepeatUserException;

public interface LoginService {
    /**
     *
     * @param name
     * @param password
     * @return
     */
    LoginExecution getUser(String name, String password);

    /**
     *
     * @param name
     * @param password
     * @return
     */
    LoginExecution insertUser(String name, String password) throws LoginException,RepeatUserException;
}
