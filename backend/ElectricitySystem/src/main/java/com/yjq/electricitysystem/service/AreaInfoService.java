package com.yjq.electricitysystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.entity.AreaInfo;
import com.yjq.electricitysystem.mapper.AreaInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaInfoService {

    @Resource
    private AreaInfoMapper areaMapper;


    public void add(AreaInfo areaInfo) {
        areaMapper.insert(areaInfo);
    }

    public void update(AreaInfo areaInfo) {
        areaMapper.updateById(areaInfo);
    }

    public void deleteById(Integer id) {
        areaMapper.deleteById(id);
    }

    public PageInfo<AreaInfo> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AreaInfo> list = areaMapper.selectAll();
        return PageInfo.of(list);
    }



}
