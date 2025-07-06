// src/main/java/com/yjq/electricitysystem/entity/ElectricityPrice.java
package com.yjq.electricitysystem.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_electricityprice", schema = "OMS")
@IdClass(ElectricityPriceInfoId.class)
public class ElectricityPriceInfo {

    @Id
    @Column(name = "electricity_beginnum")
    private Integer electricityBeginnum;

    @Id
    @Column(name = "electricity_endnum")
    private Integer electricityEndnum;

    @Id
    @Column(name = "electricity_type")
    private Integer electricityType;

    @Column(name = "price", precision = 20, scale = 2, nullable = false)
    private BigDecimal price;

    public ElectricityPriceInfo() {}

    public ElectricityPriceInfo(Integer electricityBeginnum, Integer electricityEndnum, Integer electricityType, BigDecimal price) {
        this.electricityBeginnum = electricityBeginnum;
        this.electricityEndnum  = electricityEndnum;
        this.electricityType    = electricityType;
        this.price              = price;
    }

    public Integer getElectricityBeginnum() {
        return electricityBeginnum;
    }
    public void setElectricityBeginnum(Integer electricityBeginnum) {
        this.electricityBeginnum = electricityBeginnum;
    }

    public Integer getElectricityEndnum() {
        return electricityEndnum;
    }
    public void setElectricityEndnum(Integer electricityEndnum) {
        this.electricityEndnum = electricityEndnum;
    }

    public Integer getElectricityType() {
        return electricityType;
    }
    public void setElectricityType(Integer electricityType) {
        this.electricityType = electricityType;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
