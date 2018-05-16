package com.pino.login.dao;

import junit.framework.TestCase;
import com.pino.login.entity.Login;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class LoginMapperTest {
    private final String salt = "thisIsASaltValue";
    @Resource
    private LoginMapper login;
    private String getMd5(String password){
        String base = password + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
    @Test
    public void testRegister() {
        LocalDateTime localDateTimedateTime = LocalDateTime.now();
        String str = getMd5("123456");
        int i = login.register("pino", str, localDateTimedateTime, localDateTimedateTime);
        System.out.println(i);
    }
    @Test
    public void testLogin() {
        String str = getMd5("123456");
        Login i = login.login("pino", str);
        System.out.println(i);
    }
}