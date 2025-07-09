package com.yjq.electricitysystem.mapper;

import com.yjq.electricitysystem.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminMapper {
    List<Admin> selectAll();

    @Select("select * from OMS.T_ADMININFO where ADMIN_CODE=#{type}")
    // 报错，因为没用list一次只能查一条数据，但是这里可以查5条
    Admin selectByType(Integer type);

    void insert(Admin admin);

    void updateById(Admin admin);

    @Delete("DELETE  FROM OMS.T_ADMININFO WHERE ADMIN_CODE = #{code}")
    void deleteById(Integer code);

    //登录用
    @Select("select * from OMS.T_ADMININFO where ADMIN_CODE=#{admincode}")
    Admin selecrByadmincode(Integer admincode);

    /** 只查询管理员类型，审批用 */
    @Select("SELECT admin_type FROM OMS.t_admininfo WHERE admin_code = #{adminCode}")
    Integer selectAdminType(@Param("adminCode") Integer adminCode);

}
