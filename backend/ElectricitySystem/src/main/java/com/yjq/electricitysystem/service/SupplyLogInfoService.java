package com.yjq.electricitysystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.entity.Admin;
import com.yjq.electricitysystem.entity.SupplyLogInfo;
import com.yjq.electricitysystem.mapper.SupplyLogInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyLogInfoService {

    @Resource
    private SupplyLogInfoMapper supplyLogInfoMapper;

    public PageInfo<SupplyLogInfo> selectPage(
            Integer areaCode,
            String startDate,
            String endDate,
            Integer pageNum,
            Integer pageSize
    ) {
        PageHelper.startPage(pageNum, pageSize);
        List<SupplyLogInfo> list = supplyLogInfoMapper.selectPagefindAll(areaCode, startDate, endDate);
        return new PageInfo<>(list);
    }
}
