package com.yjq.electricitysystem.controller;


import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.entity.AreaInfo;
import com.yjq.electricitysystem.entity.ElectricityPriceInfo;
import com.yjq.electricitysystem.service.AreaInfoService;
import com.yjq.electricitysystem.service.ElectricityPriceInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/electricityprice")
public class ElectricityPriceInfoController {

    @Resource
    private ElectricityPriceInfoService electricityPriceInfoService;

    // 分页查询,pageNum为当前页码，pageSize为页面大小
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "15") Integer pageSize) {
        PageInfo<ElectricityPriceInfo> pageInfo = electricityPriceInfoService.selectPage(pageNum, pageSize);
        return Result.success(pageInfo);
    }
}
