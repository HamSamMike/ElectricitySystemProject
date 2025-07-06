// src/main/java/com/yjq/electricitysystem/entity/ConsumptionLog.java
package com.yjq.electricitysystem.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_consumptionlog", schema = "OMS")
@IdClass(ConsumptionlogInfoId.class)
public class ConsumptionlogInfo {

    @Id
    @Column(name = "logdate")
    private LocalDate logDate;

    @Id
    @Column(name = "user_code")
    private Integer userCode;

    @Id
    @Column(name = "area_code")
    private Integer areaCode;

    @Id
    @Column(name = "community_code")
    private Integer communityCode;

    @Column(name = "consume_num", precision = 20, scale = 2, nullable = false)
    private BigDecimal consumeNum;

    public ConsumptionlogInfo() {}

    public ConsumptionlogInfo(LocalDate logDate, Integer userCode, Integer areaCode, Integer communityCode, BigDecimal consumeNum) {
        this.logDate       = logDate;
        this.userCode      = userCode;
        this.areaCode      = areaCode;
        this.communityCode = communityCode;
        this.consumeNum    = consumeNum;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
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

    public BigDecimal getConsumeNum() {
        return consumeNum;
    }

    public void setConsumeNum(BigDecimal consumeNum) {
        this.consumeNum = consumeNum;
    }
}
