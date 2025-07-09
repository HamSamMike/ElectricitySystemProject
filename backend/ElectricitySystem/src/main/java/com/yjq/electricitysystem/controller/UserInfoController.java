// src/main/java/com/example/demo/controller/UserInfoController.java
package com.yjq.electricitysystem.controller;

import com.yjq.electricitysystem.common.Result;
import com.yjq.electricitysystem.dto.ConsumptionDto;
import com.yjq.electricitysystem.dto.PasswordChangeDto;
import com.yjq.electricitysystem.dto.UserInfoDto;
import com.yjq.electricitysystem.entity.UserInfo;
import com.yjq.electricitysystem.service.UserInfoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import org.springframework.security.oauth2.jwt.Jwt;

import java.math.BigDecimal;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/users")
public class UserInfoController {
    private final UserInfoService service;

    public UserInfoController(UserInfoService service) {
        this.service = service;
    }

    /**
     * 1. 查询单个用户信息（密码字段 null）
     */
    @GetMapping("/{userCode}")
    public Result getById(@PathVariable Integer userCode) {
        UserInfo u = service.getById(userCode);
        return Result.success(u);
    }

    /**
     * 2. 修改密码
     */
    @PutMapping("/{userCode}/password")
    public Result changePassword(
            @PathVariable Integer userCode,
            @RequestParam String newPwd
    ) {
        service.changePassword(userCode,newPwd);
        return Result.success();
    }

    /**
     * 3. 查询指定月份用电 (YYYY-MM)
     */
    @GetMapping("/{userCode}/consumption")
    public Result consumption(
            @PathVariable Integer userCode,
            @RequestParam @Pattern(regexp = "\\d{4}-\\d{2}") String month
    ) {
        UserInfoService.ConsumptionResult cr = service.getConsumption(userCode, month);
        return Result.success(cr);
    }
}