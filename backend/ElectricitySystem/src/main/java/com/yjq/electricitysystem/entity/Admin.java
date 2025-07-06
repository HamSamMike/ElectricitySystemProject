package com.yjq.electricitysystem.entity;

import java.math.BigDecimal;

public class Admin {
    private Integer adminCode;      // ⬅ 用 Integer 而不是 int 也更保险
    private String  adminName;
    private String  adminPasswd;
    private Integer adminType;      // ⬅ 和表里 INT 对应
    private Integer areaCode;

    // --- 一定要有下面这些标准的 getter/setter ---
    public Integer getAdminCode() {
        return adminCode;
    }
    public void setAdminCode(Integer adminCode) {
        this.adminCode = adminCode;
    }

    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPasswd() {
        return adminPasswd;
    }
    public void setAdminPasswd(String adminPasswd) {
        this.adminPasswd = adminPasswd;
    }

    public Integer getAdminType() {
        return adminType;
    }
    public void setAdminType(Integer adminType) {
        this.adminType = adminType;
    }

    public Integer getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }
}
