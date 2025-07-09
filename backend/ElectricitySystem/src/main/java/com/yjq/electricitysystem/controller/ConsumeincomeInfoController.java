package com.yjq.electricitysystem.controller;

import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.entity.Admin;
import com.yjq.electricitysystem.entity.ConsumeincomeInfo;
import com.yjq.electricitysystem.service.ConsumeincomeInfoService;
import com.yjq.electricitysystem.service.ConsumptionlogInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/Consumeincome")
public class ConsumeincomeInfoController {

    @Resource
    private ConsumeincomeInfoService consumeincomeInfoService;

    //生成对应数据，传如区域代码和月份。生成每个区域里每个小区每个月的总用电量
    @PostMapping("/generate/{areaCode}/{month}")
    public Result generateInfo(@PathVariable Integer areaCode, @PathVariable String month) {
        consumeincomeInfoService.generateInfo(areaCode,month);
        return Result.success();
    }

    //查询某个区域里面每个社区的该月份月度用电（分局电费月度报表）
    @GetMapping("selectSubBureaus/{areaCode}/{month}")
    public Result selectSubBureaus(@PathVariable Integer areaCode, @PathVariable String month) {
        List<ConsumeincomeInfo> list = consumeincomeInfoService.selectSubBureaus(areaCode,month);
        return Result.success(list);
    }

    @GetMapping("/selectGeneralAdministration")
    public Result selectGeneralAdministration(
            @RequestParam("areaName") String areaName,
            @RequestParam("month")    String month) {
        List<ConsumeincomeInfo> list =
                consumeincomeInfoService.selectGeneralAdministration(areaName, month);
        return Result.success(list);
    }
}
