package com.yjq.electricitysystem.dto;

public class SupplyStatusApproveDTO {
    private String  logDate;       // 'YYYY-MM-DD'

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(Integer adminCode) {
        this.adminCode = adminCode;
    }

    public Integer getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(Integer communityCode) {
        this.communityCode = communityCode;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    private Integer areaCode;
    private Integer communityCode;
    private Integer adminCode;     // 总局管理员账号
    private Integer status;        // 1=通过,2=不通过
    // getter / setter ...
}
