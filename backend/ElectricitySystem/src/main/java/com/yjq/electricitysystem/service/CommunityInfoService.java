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

    public List<CommunityInfo> selectPage() {
        return CommunityInfoMapper.selectPage();

    }
    //特定区域所有社区
    public List<CommunityInfo> selectPageCode(Integer code) {
        return CommunityInfoMapper.selectByAreaCode(code);
    }

    //特定社区
    public CommunityInfo selectById(Integer code,Integer id) {
        return CommunityInfoMapper.selectById(code,id);
    }
}
