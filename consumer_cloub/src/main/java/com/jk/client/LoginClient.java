package com.jk.client;

import com.jk.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("plogin")
public interface LoginClient {
    @RequestMapping("login")
    User invokeLogin(User user);
}
