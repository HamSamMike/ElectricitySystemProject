// src/main/java/com/yjq/electricitysystem/entity/ConsumptionLogId.java
package com.yjq.electricitysystem.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 复合主键类：对应 t_consumptionlog 表的 (logdate, user_code, area_code, community_code)
 */
public class ConsumptionlogInfoId implements Serializable {
    private LocalDate logDate;
    private Integer   userCode;
    private Integer   areaCode;
    private Integer   communityCode;

    public ConsumptionlogInfoId() {}

    public ConsumptionlogInfoId(LocalDate logDate, Integer userCode, Integer areaCode, Integer communityCode) {
        this.logDate       = logDate;
        this.userCode      = userCode;
        this.areaCode      = areaCode;
        this.communityCode = communityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsumptionlogInfoId)) return false;
        ConsumptionlogInfoId that = (ConsumptionlogInfoId) o;
        return Objects.equals(logDate, that.logDate)
                && Objects.equals(userCode, that.userCode)
                && Objects.equals(areaCode, that.areaCode)
                && Objects.equals(communityCode, that.communityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logDate, userCode, areaCode, communityCode);
    }

    // getters/setters omitted for brevity
}
