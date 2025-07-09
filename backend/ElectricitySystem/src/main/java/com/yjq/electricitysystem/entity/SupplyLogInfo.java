package com.yjq.electricitysystem.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_supplylog", schema = "OMS")
@IdClass(SupplyLogInfoId.class)
public class SupplyLogInfo {

    @Id
    @Column(name = "logdate", nullable = false)
    private LocalDate logDate;

    @Id
    @Column(name = "area_code", nullable = false)
    private Integer areaCode;

    @Id
    @Column(name = "community_code", nullable = false)
    private Integer communityCode;

    @Column(name = "supply_num", precision = 20, scale = 2, nullable = false)
    private BigDecimal supplyNum;

    public SupplyLogInfo() {
    }

    public SupplyLogInfo(LocalDate logDate, Integer areaCode, Integer communityCode, BigDecimal supplyNum) {
        this.logDate       = logDate;
        this.areaCode      = areaCode;
        this.communityCode = communityCode;
        this.supplyNum     = supplyNum;
    }

    // --- getters & setters ---

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
    //-------------------传参用---------------------
    /** 该区间内的去重用户数 */
    private Integer userCount;
    /** 该区间内的某天用电量 */
    private BigDecimal totalConsume;
    /** 该区间内的某天供电量 */
    private BigDecimal totalSupply;

    // Getter & Setter
    public Integer getUserCount() {
        return userCount;
    }
    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
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
