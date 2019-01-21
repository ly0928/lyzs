package com.jk.service.impl;

import com.jk.mapper.LoginMapper;
import com.jk.pojo.User;
import com.jk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public User selectAccountAndPwd(User user) {
        return loginMapper.selectAccountAndPwd(user);
    }
}
