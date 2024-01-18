package com.oras.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 * @author oras
 */
@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = -6200503009689812137L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
    private String code;



}
