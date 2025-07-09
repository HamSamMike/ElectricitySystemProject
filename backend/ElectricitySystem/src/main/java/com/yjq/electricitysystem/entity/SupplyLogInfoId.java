package com.yjq.electricitysystem.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class SupplyLogInfoId implements Serializable {

    private LocalDate logDate;
    private Integer areaCode;
    private Integer communityCode;

    public SupplyLogInfoId() {
    }

    public SupplyLogInfoId(LocalDate logDate, Integer areaCode, Integer communityCode) {
        this.logDate       = logDate;
        this.areaCode      = areaCode;
        this.communityCode = communityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplyLogInfoId)) return false;
        SupplyLogInfoId that = (SupplyLogInfoId) o;
        return Objects.equals(logDate, that.logDate) &&
                Objects.equals(areaCode, that.areaCode) &&
                Objects.equals(communityCode, that.communityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logDate, areaCode, communityCode);
    }

    // 如果需要，也可以加 getters/setters
}
