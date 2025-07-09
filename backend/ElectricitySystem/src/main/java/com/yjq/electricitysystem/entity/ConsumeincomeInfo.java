// src/main/java/com/yjq/electricitysystem/entity/ConsumeincomeInfo.java
package com.yjq.electricitysystem.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_consumeincome", schema = "OMS")
@IdClass(ConsumeincomeInfoId.class)
public class ConsumeincomeInfo {

    /** 电费产生时间，默认 SYSDATE */
    @Column(name = "income_time", nullable = false)
    private LocalDateTime incomeTime;

    /** 电费月份（当月第一天） */
    @Id
    @Column(name = "fee_month", nullable = false)
    private String feeMonth;

    /** 街道编码 */
    @Id
    @Column(name = "community_code")
    private Integer communityCode;

    /** 区域编码 */
    @Id
    @Column(name = "area_code")
    private Integer areaCode;

    /** 总电费用 */
    @Column(name = "total_fee", precision = 20, scale = 2)
    private BigDecimal totalFee;

    private String areaName;
    private BigDecimal totalConsume;
    private BigDecimal totalSupply;

    public ConsumeincomeInfo() {}

    public ConsumeincomeInfo(LocalDateTime incomeTime,
                             String feeMonth,
                             Integer communityCode,
                             Integer areaCode,
                             BigDecimal totalFee) {
        this.incomeTime    = incomeTime;
        this.feeMonth      = feeMonth;
        this.communityCode = communityCode;
        this.areaCode      = areaCode;
        this.totalFee      = totalFee;
    }

    // ========== getters & setters ==========

    public LocalDateTime getIncomeTime() {
        return incomeTime;
    }
    public void setIncomeTime(LocalDateTime incomeTime) {
        this.incomeTime = incomeTime;
    }

    public String getFeeMonth() {
        return feeMonth;
    }
    public void setFeeMonth(String feeMonth) {
        this.feeMonth = feeMonth;
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

    public BigDecimal getTotalFee() {
        return totalFee;
    }
    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public BigDecimal getTotalConsume() {
        return totalConsume;
    }

    public void setTotalConsume(BigDecimal totalConsume) {
        this.totalConsume = totalConsume;
    }

    public BigDecimal getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(BigDecimal totalSupply) {
        this.totalSupply = totalSupply;
    }
}
