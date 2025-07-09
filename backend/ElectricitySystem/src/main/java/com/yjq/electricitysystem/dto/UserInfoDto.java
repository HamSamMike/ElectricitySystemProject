package com.yjq.electricitysystem.dto;

import java.math.BigDecimal;

public class UserInfoDto {
    private Integer userCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(Integer communityCode) {
        this.communityCode = communityCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    private String userName;
    private Integer areaCode;
    private Integer communityCode;
    private BigDecimal balance;
    // getters/setters
}
