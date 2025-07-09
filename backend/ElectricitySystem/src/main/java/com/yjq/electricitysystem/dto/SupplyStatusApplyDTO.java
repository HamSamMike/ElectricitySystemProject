package com.yjq.electricitysystem.dto;

import java.math.BigDecimal;

public class SupplyStatusApplyDTO {
    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
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

    public BigDecimal getSupplyNum() {
        return supplyNum;
    }

    public void setSupplyNum(BigDecimal supplyNum) {
        this.supplyNum = supplyNum;
    }

    public Integer getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(Integer adminCode) {
        this.adminCode = adminCode;
    }

    private String  logDate;       // 'YYYY-MM-DD'
    private Integer areaCode;
    private Integer communityCode;
    private BigDecimal supplyNum;  // 前端也可以不用传，服务端会计算
    private Integer adminCode;     // 分局管理员账号
    // getter / setter ...
}
