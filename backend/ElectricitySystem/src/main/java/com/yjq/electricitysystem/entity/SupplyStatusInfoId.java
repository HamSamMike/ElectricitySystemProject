// src/main/java/com/yjq/electricitysystem/entity/SupplyStatusInfoId.java
package com.yjq.electricitysystem.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 复合主键：logDate + areaCode + communityCode
 */
public class SupplyStatusInfoId implements Serializable {
    private LocalDate logDate;
    private Integer   areaCode;
    private Integer   communityCode;

    public SupplyStatusInfoId() {}

    public SupplyStatusInfoId(LocalDate logDate, Integer areaCode, Integer communityCode) {
        this.logDate       = logDate;
        this.areaCode      = areaCode;
        this.communityCode = communityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplyStatusInfoId)) return false;
        SupplyStatusInfoId that = (SupplyStatusInfoId) o;
        return Objects.equals(logDate, that.logDate)
                && Objects.equals(areaCode, that.areaCode)
                && Objects.equals(communityCode, that.communityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logDate, areaCode, communityCode);
    }

    // getters/setters omitted for brevity
}
