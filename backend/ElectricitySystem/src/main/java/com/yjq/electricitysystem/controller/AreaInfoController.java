package com.yjq.electricitysystem.controller;

import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.entity.Admin;
import com.yjq.electricitysystem.entity.AreaInfo;
import com.yjq.electricitysystem.service.AdminService;
import com.yjq.electricitysystem.service.AreaInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/areas")
public class AreaInfoController {

    @Resource
    private AreaInfoService areaInfoService;

//    @PostMapping("/add")
//    // 增加数据
//    public Result addAreaInfo(@RequestBody AreaInfo areaInfo){
//        areaInfoService.add(areaInfo);
//        return Result.success();
//    }

//    @PutMapping("/update")
//    // 更新数据
//    public Result updateAreaInfo(@RequestBody AreaInfo areaInfo){
//        areaInfoService.update(areaInfo);
//        return Result.success();
//    }

//    @DeleteMapping("/deleteById/{id}")
//    // 删除单个数据
//    public Result deleteByIdAreaInfo(@PathVariable Integer id){
//        areaInfoService.deleteById(id);
//        return Result.success();
//    }

    // 查询单个区域的数据
    @GetMapping("/selectById/{id}")
    public Result selectAll(@PathVariable Integer id) {
        AreaInfo areaInfo = areaInfoService.selectById(id);
        return Result.success(areaInfo);
    }

    // 分页查询,pageNum为当前页码，pageSize为页面大小
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "15") Integer pageSize) {
        PageInfo<AreaInfo> pageInfo = areaInfoService.selectPage(pageNum, pageSize);
        return Result.success(pageInfo);
    }
}
