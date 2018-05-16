package com.pino.login.service;

import com.pino.login.dao.LoginMapper;
import com.pino.login.dto.LoginExecution;
import com.pino.login.entity.Login;
import com.pino.login.enums.LoginStatEnum;
import com.pino.login.exception.LoginException;
import com.pino.login.exception.RepeatUserException;
import com.pino.login.service.interfaces.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /*  */
    private final String salt = "thisIsASaltValue";
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginExecution getUser(String name, String password) {
        Login user = loginMapper.login(name, getMd5(password));
        System.out.println(user);
        if(user == null){
            return  new LoginExecution(LoginStatEnum.WRONG);
        }else {
            return  new LoginExecution(LoginStatEnum.PASS,loginMapper.login(name, getMd5(password)));
        }

    }

    @Override
    public LoginExecution insertUser(String name, String password) throws LoginException,RepeatUserException{
        LocalDateTime localDateTime = LocalDateTime.now();
        try{
            int result = loginMapper.register(name, getMd5(password), localDateTime, localDateTime);
            if(result <= 0){
                logger.warn("用户添加失败");

                throw new LoginException("user register failed");
            }else{
                return new LoginExecution(LoginStatEnum.SUCCESS);
            }
        }catch (LoginException e){
            logger.error(e.getMessage(), e);
            return new LoginExecution(LoginStatEnum.FAIL);
        }
    }

    private String getMd5(String password) {
        String base = password + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

}
