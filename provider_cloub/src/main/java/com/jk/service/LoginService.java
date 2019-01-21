package com.jk.service;

import com.jk.pojo.User;

public interface LoginService {
    User selectAccountAndPwd(User user);
}
