package com.yjq.electricitysystem.mapper;

import com.yjq.electricitysystem.entity.Admin;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper {
    List<Admin> selectAll();

    @Select("select * from OMS.T_ADMININFO where ADMIN_TYPE=#{type}")
    // 报错，因为没用list一次只能查一条数据，但是这里可以查5条
    Admin selectByType(Integer type);
}
