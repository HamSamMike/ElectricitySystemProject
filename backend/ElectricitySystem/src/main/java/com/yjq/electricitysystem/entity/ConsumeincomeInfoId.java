// src/main/java/com/yjq/electricitysystem/entity/ConsumeincomeInfoId.java
package com.yjq.electricitysystem.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 复合主键：feeMonth + communityCode + areaCode
 */
public class ConsumeincomeInfoId implements Serializable {
    private LocalDate feeMonth;
    private Integer   communityCode;
    private Integer   areaCode;

    public ConsumeincomeInfoId() {}

    public ConsumeincomeInfoId(LocalDate feeMonth, Integer communityCode, Integer areaCode) {
        this.feeMonth      = feeMonth;
        this.communityCode = communityCode;
        this.areaCode      = areaCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsumeincomeInfoId)) return false;
        ConsumeincomeInfoId that = (ConsumeincomeInfoId) o;
        return Objects.equals(feeMonth, that.feeMonth)
                && Objects.equals(communityCode, that.communityCode)
                && Objects.equals(areaCode, that.areaCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feeMonth, communityCode, areaCode);
    }

    // getters & setters omitted for brevity
}
