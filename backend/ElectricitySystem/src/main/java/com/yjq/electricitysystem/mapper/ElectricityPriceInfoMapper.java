package com.yjq.electricitysystem.mapper;

import com.yjq.electricitysystem.entity.ElectricityPriceInfo;

import java.util.List;

public interface ElectricityPriceInfoMapper {
    public List<ElectricityPriceInfo> selectAll();
}
