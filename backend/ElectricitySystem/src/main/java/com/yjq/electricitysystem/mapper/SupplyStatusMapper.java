package com.yjq.electricitysystem.mapper;

import com.yjq.electricitysystem.entity.SupplyStatusInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface SupplyStatusMapper {

    /** 插入一条申请 */
    int insert(SupplyStatusInfo rec);
    /** 查询指定状态的申请列表 */
    List<SupplyStatusInfo> selectByStatus(@Param("status") Integer status);
    /** 更新审批结果 */
    int updateStatus(SupplyStatusInfo rec);


}
