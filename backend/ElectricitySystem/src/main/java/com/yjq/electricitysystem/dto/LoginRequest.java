package com.yjq.electricitysystem.dto;

public class LoginRequest {
    private Integer userCode;
    private String userPasswd;

    public LoginRequest() {
    }

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }
}
