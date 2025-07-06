package com.yjq.electricitysystem.controller;

import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.entity.Admin;
import com.yjq.electricitysystem.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Resource
    private AdminService adminService;

    // 查询所有管理员admin数据
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Admin> list = adminService.selectAll();
        return Result.success(list);
    }

    // 查询单个管理员type=1的数据
    @GetMapping("/selectByType/{type}")
    public Result selectAll(@PathVariable Integer type) {
            Admin admin = adminService.selectByType(type);
            return Result.success(admin);
    }

    // 分页查询,pageNum为当前页码，pageSize为页面大小
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "15") Integer pageSize) {
        PageInfo<Admin> pageInfo = adminService.selectPage(pageNum, pageSize);
        return Result.success(pageInfo);
    }

    /**
     * DELETE /api/v1/admins/{adminCode}
     * 删除管理员
     */
//    @DeleteMapping("/{adminCode}")
//    public Result<Void> delete(@PathVariable Long adminCode) {
//        adminService.delete(adminCode);
//        return Result.success();
//    }
}
