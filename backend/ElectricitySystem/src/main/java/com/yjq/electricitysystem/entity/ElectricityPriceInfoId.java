// src/main/java/com/yjq/electricitysystem/entity/ElectricityPriceId.java
package com.yjq.electricitysystem.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 复合主键类：对应 t_electricityprice 表的 (electricity_beginnum, electricity_endnum, electricity_type)
 */
public class ElectricityPriceInfoId implements Serializable {
    private Integer electricityBeginnum;
    private Integer electricityEndnum;
    private Integer electricityType;

    public ElectricityPriceInfoId() {}

    public ElectricityPriceInfoId(Integer electricityBeginnum, Integer electricityEndnum, Integer electricityType) {
        this.electricityBeginnum = electricityBeginnum;
        this.electricityEndnum  = electricityEndnum;
        this.electricityType    = electricityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricityPriceInfoId)) return false;
        ElectricityPriceInfoId that = (ElectricityPriceInfoId) o;
        return Objects.equals(electricityBeginnum, that.electricityBeginnum)
                && Objects.equals(electricityEndnum, that.electricityEndnum)
                && Objects.equals(electricityType, that.electricityType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(electricityBeginnum, electricityEndnum, electricityType);
    }

    // getters and setters...
}
