package com.yjq.electricitysystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_area", schema = "OMS")
public class AreaInfo {

    @Id
    @Column(name = "area_code")
    private Integer areaCode;

    @Column(name = "area_name", length = 20, nullable = false)
    private String areaName;

    public AreaInfo() {
    }

    public AreaInfo(Integer areaCode, String areaName) {
        this.areaCode = areaCode;
        this.areaName = areaName;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
