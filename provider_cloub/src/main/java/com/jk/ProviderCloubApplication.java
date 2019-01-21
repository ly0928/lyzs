package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//标明此项目是一个生产者 往服务中心进行注册时候 可以让其他项目发现并进行调用
@EnableDiscoveryClient//可以往服务中心进行注册
@MapperScan("com.jk.mapper")
public class ProviderCloubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderCloubApplication.class, args);
    }

}

