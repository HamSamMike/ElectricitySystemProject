package com.yjq.electricitysystem.controller;

import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.dto.SupplyStatusApplyDTO;
import com.yjq.electricitysystem.dto.SupplyStatusApproveDTO;
import com.yjq.electricitysystem.service.SupplyStatusService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/SupplyStatus")
public class SupplyStatusController {

    @Resource
    private SupplyStatusService supplyStatusService;

    /** 分局管理员申请 */
    @PostMapping("/apply")
    public Result apply(@RequestBody SupplyStatusApplyDTO dto) {
        supplyStatusService.apply(dto);
        return Result.success();
    }

    /** 查询所有待审批 */
    @GetMapping("/pending")
    public Result listPending() {
        return Result.success(supplyStatusService.listByStatus(0));
    }

    /** 总局管理员审批 */
    @PostMapping("/approve")
    public Result approve(@RequestBody SupplyStatusApproveDTO dto) {
        supplyStatusService.approve(dto);
        return Result.success();
    }
}
