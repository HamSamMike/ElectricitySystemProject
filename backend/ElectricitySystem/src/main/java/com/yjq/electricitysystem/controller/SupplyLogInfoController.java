package com.yjq.electricitysystem.controller;

import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.entity.Admin;
import com.yjq.electricitysystem.entity.SupplyLogInfo;
import com.yjq.electricitysystem.service.SupplyLogInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/supplylog")
public class SupplyLogInfoController {
    // 接收一个area_code和两个日期，返回这个区域的所有街道的用户数，这两个日期的电量
    @Resource
    private SupplyLogInfoService supplyLogInfoService;

    /**
     * 按 区域 + 两个日期 ，查询用户数 & 当日用电 & 当日供电
     */
    @GetMapping("/selectPage")
    public Result selectPage(
            @RequestParam Integer areaCode,
            @RequestParam String startDate,       // YYYY-MM-DD，用于用电查询
            @RequestParam String endDate,         // YYYY-MM-DD，用于供电查询
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "15") Integer pageSize
    ) {
        PageInfo<SupplyLogInfo> pageInfo =
                supplyLogInfoService.selectPage(areaCode, startDate, endDate, pageNum, pageSize);
        return Result.success(pageInfo);
    }

}
