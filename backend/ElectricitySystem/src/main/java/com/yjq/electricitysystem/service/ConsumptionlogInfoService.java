package com.yjq.electricitysystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.entity.AreaInfo;
import com.yjq.electricitysystem.entity.ConsumptionlogInfo;
import com.yjq.electricitysystem.mapper.AreaInfoMapper;
import com.yjq.electricitysystem.mapper.ConsumptionlogInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionlogInfoService {

    @Resource
    private ConsumptionlogInfoMapper consumptionlogInfoMapper;

    public PageInfo<ConsumptionlogInfo> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ConsumptionlogInfo> list = consumptionlogInfoMapper.selectAll();
        return PageInfo.of(list);
    }
}
