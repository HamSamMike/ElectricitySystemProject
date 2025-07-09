package com.yjq.electricitysystem.controller;

import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.entity.AreaInfo;
import com.yjq.electricitysystem.entity.CommunityInfo;
import com.yjq.electricitysystem.service.AreaInfoService;
import com.yjq.electricitysystem.service.CommunityInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communities")
public class CommunityInfoController {

    @Resource
    private CommunityInfoService communityInfoService;

//    // 分页查询,pageNum为当前页码，pageSize为页面大小
//    @GetMapping("/selectPage")
//    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
//                             @RequestParam(defaultValue = "15") Integer pageSize) {
//        PageInfo<CommunityInfo> pageInfo = communityInfoService.selectPage(pageNum, pageSize);
//        return Result.success(pageInfo);
//    }
//
//    // 分页查询,查询特定区域的所有社区
//    @GetMapping("/selectPageCode/{code}")
//    public Result selectPageCode(@PathVariable Integer code,
//                                 @RequestParam(defaultValue = "1") Integer pageNum,
//                                 @RequestParam(defaultValue = "15") Integer pageSize) {
//        PageInfo<CommunityInfo> pageInfo = communityInfoService.selectPageCode(code, pageNum, pageSize);
//        return Result.success(pageInfo);
//    }

    // 查询所有社区
    @GetMapping("/selectPage")
    public Result selectPage() {
        List<CommunityInfo> list = communityInfoService.selectPage();
        return Result.success(list);

    }

    // 查询特定区域的所有社区
    @GetMapping("/selectPageCode/{code}")
    public Result selectPageCode(@PathVariable Integer code) {
        List<CommunityInfo> list = communityInfoService.selectPageCode(code);
        return Result.success(list);
    }


    // 查询特定区域特定代码的社区
    @GetMapping("/selectById/{code}/{id}")
    public Result selectById(@PathVariable Integer code,@PathVariable Integer id) {
        CommunityInfo communityInfo = communityInfoService.selectById(code,id);
        return Result.success(communityInfo);
    }

}
