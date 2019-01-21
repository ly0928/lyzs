package com.jk.pojo;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String account;
    private String userPwd;
    private String remPwd;
}
