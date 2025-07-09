package com.yjq.electricitysystem.service;

import com.yjq.electricitysystem.entity.ConsumeincomeInfo;
import com.yjq.electricitysystem.mapper.ConsumeincomeInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumeincomeInfoService {

    @Resource
    private ConsumeincomeInfoMapper consumeincomeInfoMapper;

    public void generateInfo(Integer areaCode, String month) {
        consumeincomeInfoMapper.generateInfo(areaCode,month);

    }

    /**
     * 查询某区域下各分局（社区）当月总电费
     */
    public List<ConsumeincomeInfo> selectSubBureaus(Integer areaCode, String month) {
        return consumeincomeInfoMapper.selectSubBureaus(areaCode, month);
    }

    /**
     * 查询某区域每个月（1～6月）的总电费——基于视图 v_consumptionnum
     */
    public List<ConsumeincomeInfo> selectGeneralAdministration(String areaName, String month) {
        return consumeincomeInfoMapper.selectGeneralAdministration(areaName, month);
    }
}
