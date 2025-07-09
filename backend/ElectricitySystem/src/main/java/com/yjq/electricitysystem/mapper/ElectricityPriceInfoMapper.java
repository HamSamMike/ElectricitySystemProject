package com.yjq.electricitysystem.mapper;

import com.yjq.electricitysystem.entity.ElectricityPriceInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ElectricityPriceInfoMapper {
    public List<ElectricityPriceInfo> selectAll();

    @Select("select * from OMS.T_ELECTRICITYPRICE where ELECTRICITY_TYPE=#{id}")
    ElectricityPriceInfo selectById(Integer id);
}
