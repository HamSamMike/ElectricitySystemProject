package com.yjq.electricitysystem.service;

import com.yjq.electricitysystem.dto.SupplyStatusApplyDTO;
import com.yjq.electricitysystem.dto.SupplyStatusApproveDTO;
import com.yjq.electricitysystem.entity.SupplyStatusInfo;
import com.yjq.electricitysystem.exception.CustomException;
import com.yjq.electricitysystem.mapper.AdminMapper;
import com.yjq.electricitysystem.mapper.SupplyLogMapper;
import com.yjq.electricitysystem.mapper.SupplyStatusMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SupplyStatusService {

    @Resource
    private SupplyStatusMapper supplyStatusMapper;
    @Autowired
    private SupplyLogMapper supplyLogMapper; // 读取 t_supplylog
    @Resource
    private AdminMapper adminMapper;    // 新增

    private static final Integer TYPE_HEADQUARTER = 1;
    private static final Integer TYPE_BRANCH      = 2;

    public void apply(SupplyStatusApplyDTO dto) {
        // 1. 验证分局管理员身份
        Integer type = adminMapper.selectAdminType(dto.getAdminCode());
        if (!TYPE_BRANCH.equals(type)) {
            throw new CustomException("只有分局管理员才能申请调节", "403");
        }

        LocalDate logDate = LocalDate.parse(dto.getLogDate());
        LocalDate prev    = logDate.minusDays(1);
        // 2. 取昨日真实供电量
        BigDecimal real = supplyLogMapper
                .selectSupplyNum(dto.getAreaCode(), dto.getCommunityCode(), prev);

        // 3. 计算1.2倍，并四舍五入保留2位
        BigDecimal applyNum = real.multiply(new BigDecimal("1.2"))
                .setScale(2, RoundingMode.HALF_UP);

        // 4. 构造并插入申请
        SupplyStatusInfo rec = new SupplyStatusInfo();
        rec.setLogDate(logDate);
        rec.setAreaCode(dto.getAreaCode());
        rec.setCommunityCode(dto.getCommunityCode());
        rec.setSupplyNum(applyNum);
        rec.setAdminCode(dto.getAdminCode());
        rec.setApplyTime(LocalDateTime.now());
        rec.setStatus(0);
        supplyStatusMapper.insert(rec);
    }

    public List<SupplyStatusInfo> listByStatus(Integer status) {
        return supplyStatusMapper.selectByStatus(status);
    }

    public void approve(SupplyStatusApproveDTO dto) {
        // 1. 验证总局管理员身份
        Integer type = adminMapper.selectAdminType(dto.getAdminCode());
        if (TYPE_HEADQUARTER.equals(type)) {
            throw new CustomException("只有总局管理员才能审批", "403");
        }
        // 2. 更新审批结果
        SupplyStatusInfo rec = new SupplyStatusInfo();
        rec.setLogDate(LocalDate.parse(dto.getLogDate()));
        rec.setAreaCode(dto.getAreaCode());
        rec.setCommunityCode(dto.getCommunityCode());
        rec.setStatus(dto.getStatus());
        rec.setAdminCode(dto.getAdminCode());
        rec.setApprovalTime(LocalDateTime.now());
        supplyStatusMapper.updateStatus(rec);
    }
}
