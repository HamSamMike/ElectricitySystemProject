package com.yjq.electricitysystem.mapper;

import com.yjq.electricitysystem.entity.ConsumeincomeInfo;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsumeincomeInfoMapper {

    void generateInfo(@Param("areaCode") Integer areaCode,@Param("month") String month);

    List<ConsumeincomeInfo> selectSubBureaus(@Param("areaCode") Integer areaCode,@Param("month") String month);


    /**
     * 按区域中文名 + 月份查询用电总量和电费
     * @param areaName 区域中文名
     * @param month    月份 “YYYY-MM”
     */
    List<ConsumeincomeInfo> selectGeneralAdministration(@Param("areaName") String areaName,@Param("month") String month);
}
