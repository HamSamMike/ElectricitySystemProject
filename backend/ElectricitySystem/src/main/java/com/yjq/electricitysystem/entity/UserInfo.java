// src/main/java/com/example/demo/entity/UserInfo.java
package com.yjq.electricitysystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_userinfo", schema = "OMS")
public class UserInfo {

    @Id
    @Column(name = "user_code")
    private Integer userCode;

    @Column(name = "user_name", length = 50)
    private String userName;

    /**
     * 写时能接收，序列化到前端时不输出
     */
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "user_passwd")
    private String userPasswd;

    @Column(name = "area_code")
    private Integer areaCode;

    @Column(name = "community_code")
    private Integer communityCode;

    @Column(name = "balance", precision = 20, scale = 2)
    private BigDecimal balance;

    // --- getters & setters ---
    public Integer getUserCode() { return userCode; }
    public void setUserCode(Integer userCode) { this.userCode = userCode; }
    // 其余字段同理
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getUserPasswd() { return userPasswd; }
    public void setUserPasswd(String userPasswd) { this.userPasswd = userPasswd; }
    public Integer getAreaCode() { return areaCode; }
    public void setAreaCode(Integer areaCode) { this.areaCode = areaCode; }
    public Integer getCommunityCode() { return communityCode; }
    public void setCommunityCode(Integer communityCode) { this.communityCode = communityCode; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

}