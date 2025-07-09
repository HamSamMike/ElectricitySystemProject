package com.yjq.electricitysystem.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface SupplyLogMapper {
    @Select("SELECT NVL(SUM(supply_num),0) FROM OMS.t_supplylog " +
            "WHERE logdate = #{date} " +
            "  AND area_code = #{areaCode} " +
            "  AND community_code = #{communityCode}")
    BigDecimal selectSupplyNum(@Param("areaCode") int areaCode,
                               @Param("communityCode") int communityCode,
                               @Param("date") LocalDate date);
}
