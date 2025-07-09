package com.yjq.electricitysystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.entity.AreaInfo;
import com.yjq.electricitysystem.entity.ConsumptionlogInfo;
import com.yjq.electricitysystem.mapper.AreaInfoMapper;
import com.yjq.electricitysystem.mapper.ConsumptionlogInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ConsumptionlogInfoService {

    @Resource
    private ConsumptionlogInfoMapper consumptionlogInfoMapper;

        public BigDecimal selectPage(String month, Integer userid) {
            return consumptionlogInfoMapper.selectMonthlySum(month, userid);
    }
}
