package com.yjq.electricitysystem.mapper;

import com.yjq.electricitysystem.entity.CommunityInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommunityInfoMapper {


    @Select("SELECT * FROM  OMS.T_COMMUNITY WHERE AREA_CODE=#{code} AND COMMUNITY_CODE=#{id}")
    CommunityInfo selectById(Integer code,Integer id);

    List<CommunityInfo> selectPage();

    List<CommunityInfo> selectByAreaCode(Integer code);
}
