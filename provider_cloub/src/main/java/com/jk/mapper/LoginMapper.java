package com.jk.mapper;

import com.jk.pojo.User;

public interface LoginMapper {
    User selectAccountAndPwd(User user);
}
