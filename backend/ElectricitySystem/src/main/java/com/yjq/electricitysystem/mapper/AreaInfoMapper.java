package com.yjq.electricitysystem.mapper;

import com.yjq.electricitysystem.entity.AreaInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AreaInfoMapper {
    List<AreaInfo> selectAll();

    void insert(AreaInfo areaInfo);

    void updateById(AreaInfo areaInfo);

    @Delete("DELETE  FROM OMS.T_AREA WHERE AREA_CODE = #{id}")
    void deleteById(Integer id);

    @Select("SELECT * FROM  OMS.T_AREA WHERE AREA_CODE=#{id}")
    AreaInfo selectById(Integer id);
}
