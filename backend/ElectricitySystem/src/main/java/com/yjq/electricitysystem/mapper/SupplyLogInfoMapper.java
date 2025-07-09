package com.yjq.electricitysystem.mapper;

import com.yjq.electricitysystem.entity.SupplyLogInfo;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplyLogInfoMapper {


    /**
     * 分页查询：按 areaCode、startDate（当日用电）、endDate（当日供电）
     */
    List<SupplyLogInfo> selectPagefindAll(
            @Param("areaCode") Integer areaCode,
            @Param("startDate") String startDate,
            @Param("endDate")   String endDate
    );
}
