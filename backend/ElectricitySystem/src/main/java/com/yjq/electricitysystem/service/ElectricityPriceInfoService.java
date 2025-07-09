package com.yjq.electricitysystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.entity.AreaInfo;
import com.yjq.electricitysystem.entity.ElectricityPriceInfo;
import com.yjq.electricitysystem.mapper.AreaInfoMapper;
import com.yjq.electricitysystem.mapper.ElectricityPriceInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricityPriceInfoService {

    @Resource
    private ElectricityPriceInfoMapper electricityPriceInfoMapper;

    public PageInfo<ElectricityPriceInfo> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ElectricityPriceInfo> list = electricityPriceInfoMapper.selectAll();
        return PageInfo.of(list);
    }

    public ElectricityPriceInfo selectById(Integer id) {
        return electricityPriceInfoMapper.selectById(id);
    }
}
