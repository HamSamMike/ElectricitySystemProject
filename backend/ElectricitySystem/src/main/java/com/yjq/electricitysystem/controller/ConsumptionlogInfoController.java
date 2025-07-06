package com.yjq.electricitysystem.controller;

import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.entity.AreaInfo;
import com.yjq.electricitysystem.entity.ConsumptionlogInfo;
import com.yjq.electricitysystem.service.AreaInfoService;
import com.yjq.electricitysystem.service.ConsumptionlogInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Consumptionlogs")
public class ConsumptionlogInfoController {

    @Resource
    private ConsumptionlogInfoService consumptionlogInfoService;

    // 分页查询,pageNum为当前页码，pageSize为页面大小
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "15") Integer pageSize) {
        PageInfo<ConsumptionlogInfo> pageInfo = consumptionlogInfoService.selectPage(pageNum, pageSize);
        return Result.success(pageInfo);
    }
}
