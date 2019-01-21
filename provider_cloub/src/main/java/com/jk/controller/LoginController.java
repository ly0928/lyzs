package com.jk.controller;

import com.jk.pojo.User;
import com.jk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("login")
    public User login(@RequestBody User user){
        User userFromDB=loginService.selectAccountAndPwd(user);
        return userFromDB;
    }
}