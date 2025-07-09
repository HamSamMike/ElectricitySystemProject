package com.yjq.electricitysystem.controller;

import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.entity.Admin;
import com.yjq.electricitysystem.entity.UserInfo;
import com.yjq.electricitysystem.service.AdminService;
import com.yjq.electricitysystem.service.UserInfoService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.Resource;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.security.Keys;

import io.jsonwebtoken.io.Decoders;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Resource
    // 用户登录
    private UserInfoService userService;

    @Resource
    // 管理员登录
    private AdminService adminService;

    @PostMapping("/admin01/login")
    public Result admin01login(@RequestBody Admin admin) {
        // 调用 service，拿到脱敏后的管理员对象
        Admin db = adminService.admin01login(admin);
        // 返回完整信息
        return Result.success(db);
    }

    @PostMapping("/admin02/login")
    public Result admin02login(@RequestBody Admin admin) {
        Admin db = adminService.admin02login(admin);
        return Result.success(db);
    }

    // 普通用户登录
    @PostMapping("/user/login")
    public Result userlogin(@RequestBody UserInfo userInfo) {
        UserInfo db = userService.userlogin(userInfo);
        // 登录成功，将用户全部信息（脱敏后）返回
        return Result.success(db);
    }
}
