package com.yjq.electricitysystem.controller;

import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.entity.AreaInfo;
import com.yjq.electricitysystem.entity.ConsumptionlogInfo;
import com.yjq.electricitysystem.service.AreaInfoService;
import com.yjq.electricitysystem.service.ConsumptionlogInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/Consumptionlogs")
public class ConsumptionlogInfoController {

    @Resource
    private ConsumptionlogInfoService consumptionlogInfoService;

    // 查询某用户指定月份的用电日志
    @GetMapping("/selectPage/{month}/{userid}")
    public Result selectPage(@PathVariable String month, @PathVariable Integer userid) {
        BigDecimal sum = consumptionlogInfoService.selectPage(month,userid);
        return Result.success(sum);
    }
}
