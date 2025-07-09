package com.yjq.electricitysystem.mapper;

import com.yjq.electricitysystem.entity.ConsumptionlogInfo;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ConsumptionlogInfoMapper {


    BigDecimal selectMonthlySum(@Param("month") String month,
                                @Param("userid") Integer userid);
}
