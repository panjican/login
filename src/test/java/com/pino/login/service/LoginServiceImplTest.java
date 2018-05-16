package com.pino.login.service;

import com.pino.login.dto.LoginExecution;
import com.pino.login.entity.Login;
import com.pino.login.service.interfaces.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-service.xml"})
public class LoginServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String salt = "thisIsASaltValue";
    @Autowired
    private LoginService loginService;
    @Test
    public void getUser() {
        LoginExecution user = loginService.getUser("pino",getMd5("123456"));
        System.out.println(user);
    }

    @Test
    public void insertUser() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LoginExecution result = loginService.insertUser("pino", getMd5("123456"));
        System.out.println(result);
    }

    private String getMd5(String password) {
        String base = password + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}