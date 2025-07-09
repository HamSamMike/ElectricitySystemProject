// src/main/java/com/yjq/electricitysystem/entity/SupplyStatusInfo.java
package com.yjq.electricitysystem.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_supplystatus", schema = "OMS")
@IdClass(SupplyStatusInfoId.class)
public class SupplyStatusInfo {

    @Id
    @Column(name = "LOGDATE", nullable = false)
    private LocalDate logDate;

    @Id
    @Column(name = "AREA_CODE", nullable = false)
    private Integer areaCode;

    @Id
    @Column(name = "COMMUNITY_CODE", nullable = false)
    private Integer communityCode;

    @Column(name = "SUPPLY_NUM", precision = 20, scale = 2, nullable = false)
    private BigDecimal supplyNum;

    @Column(name = "ADMIN_CODE")
    private Integer adminCode;

    @Column(name = "APPLYTIME")
    private LocalDateTime applyTime;

    @Column(name = "APPROVALTIME")
    private LocalDateTime approvalTime;

    /**
     * 0 = 待审批, 1 = 已通过, 2 = 不通过
     */
    @Column(name = "STATUS", nullable = false)
    private Integer status;

    public SupplyStatusInfo() {}

    // 全参构造
    public SupplyStatusInfo(LocalDate logDate, Integer areaCode, Integer communityCode,
                            BigDecimal supplyNum, Integer adminCode,
                            LocalDateTime applyTime, LocalDateTime approvalTime, Integer status) {
        this.logDate       = logDate;
        this.areaCode      = areaCode;
        this.communityCode = communityCode;
        this.supplyNum     = supplyNum;
        this.adminCode     = adminCode;
        this.applyTime     = applyTime;
        this.approvalTime  = approvalTime;
        this.status        = status;
    }

    // ========== getter / setter ==========

    public LocalDate getLogDate() {
        return logDate;
    }
    public void setLogDate(LocalDate logDate) {
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

    public LocalDateTime getApplyTime() {
        return applyTime;
    }
    public void setApplyTime(LocalDateTime applyTime) {
        this.applyTime = applyTime;
    }

    public LocalDateTime getApprovalTime() {
        return approvalTime;
    }
    public void setApprovalTime(LocalDateTime approvalTime) {
        this.approvalTime = approvalTime;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}
