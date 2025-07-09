package com.yjq.electricitysystem.controller;


import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.entity.Admin;
import com.yjq.electricitysystem.entity.AreaInfo;
import com.yjq.electricitysystem.entity.ElectricityPriceInfo;
import com.yjq.electricitysystem.service.AreaInfoService;
import com.yjq.electricitysystem.service.ElectricityPriceInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/electricityprice")
public class ElectricityPriceInfoController {

    private ElectricityPriceInfo electricityPriceInfo;

    @Resource
    private ElectricityPriceInfoService electricityPriceInfoService;

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        ElectricityPriceInfo electricityPriceInfo = electricityPriceInfoService.selectById(id);
        return Result.success(electricityPriceInfo);
    }

    // 分页查询,pageNum为当前页码，pageSize为页面大小
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "15") Integer pageSize) {
        PageInfo<ElectricityPriceInfo> pageInfo = electricityPriceInfoService.selectPage(pageNum, pageSize);
        return Result.success(pageInfo);
    }
}
