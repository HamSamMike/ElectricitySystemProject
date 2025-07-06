package com.yjq.electricitysystem.controller;

import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.entity.AreaInfo;
import com.yjq.electricitysystem.entity.CommunityInfo;
import com.yjq.electricitysystem.service.AreaInfoService;
import com.yjq.electricitysystem.service.CommunityInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/communities")
public class CommunityInfoController {

    @Resource
    private CommunityInfoService communityInfoService;

    // 分页查询,pageNum为当前页码，pageSize为页面大小
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "15") Integer pageSize) {
        PageInfo<CommunityInfo> pageInfo = communityInfoService.selectPage(pageNum, pageSize);
        return Result.success(pageInfo);
    }
}
