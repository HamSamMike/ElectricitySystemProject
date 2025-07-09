package com.yjq.electricitysystem.mapper;

import com.yjq.electricitysystem.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

@Mapper
public interface UserInfoMapper {
//    @Select("SELECT * FROM OMS.t_userinfo WHERE user_code = #{userCode}")
//    UserInfo selectByUserCode(@Param("userCode") Integer userCode);

    @Update("UPDATE OMS.t_userinfo SET user_passwd = #{newPwd} WHERE user_code = #{userCode}")
    int updatePassword(@Param("userCode") Integer userCode,
                       @Param("newPwd") String newPwd);

    @Select("SELECT SUM(consume_num) FROM OMS.t_consumptionlog " +
            "WHERE TO_CHAR(logdate,'YYYY-MM') = #{month} AND user_code = #{userCode}")
    Integer sumConsume(@Param("userCode") Integer userCode,
                       @Param("month") String month);

    @Select("SELECT OMS.f_get_consumemoney(#{userCode}, #{month}) FROM dual")
    BigDecimal calcTotalCost(@Param("userCode") Integer userCode,
                             @Param("month") String month);

    /**
     * 根据用户账号查询完整用户记录
     */
    @Select("SELECT * FROM OMS.T_USERINFO WHERE USER_CODE = #{userCode}")
    UserInfo selectByUserCode(@Param("userCode") Integer userCode);
}
