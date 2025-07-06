package com.yjq.electricitysystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.entity.AreaInfo;
import com.yjq.electricitysystem.entity.CommunityInfo;
import com.yjq.electricitysystem.mapper.AreaInfoMapper;
import com.yjq.electricitysystem.mapper.CommunityInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityInfoService {

    @Resource
    private CommunityInfoMapper CommunityInfoMapper;

    public PageInfo<CommunityInfo> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CommunityInfo> list = CommunityInfoMapper.selectAll();
        return PageInfo.of(list);

    }
}
