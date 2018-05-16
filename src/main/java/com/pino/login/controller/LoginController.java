package com.pino.login.controller;

import com.pino.login.dto.LoginExecution;
import com.pino.login.dto.LoginResult;
import com.pino.login.enums.LoginStatEnum;
import com.pino.login.exception.LoginException;
import com.pino.login.service.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
public class LoginController {
    private final LoginService loginService;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request,HttpServletResponse response){
        this.request = request;
        this.response = response;
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public LoginResult<LoginExecution> register(){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        try {
            LoginExecution execution = loginService.insertUser(name, password);
            return new LoginResult<>(true, execution);
        }catch (LoginException e){
            LoginExecution execution = new LoginExecution(LoginStatEnum.FAIL);
            return new LoginResult<>(true, execution);
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public LoginResult<LoginExecution> login(){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        try {
            LoginExecution execution = loginService.getUser(name, password);
            return new LoginResult<>(true, execution);
        }catch (LoginException e){
            LoginExecution execution = new LoginExecution(LoginStatEnum.FAIL);
            return new LoginResult<>(true, execution);
        }

    }



}
