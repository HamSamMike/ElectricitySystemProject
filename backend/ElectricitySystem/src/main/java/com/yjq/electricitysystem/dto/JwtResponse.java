package com.yjq.electricitysystem.dto;

public class JwtResponse {
    private String token;
    private String userName;

    // 无参构造器（Jackson 反序列化时需要）
    public JwtResponse() {
    }

    // 有参构造器，方便直接 new
    public JwtResponse(String token, String userName) {
        this.token = token;
        this.userName = userName;
    }

    // --- getters & setters ---

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
