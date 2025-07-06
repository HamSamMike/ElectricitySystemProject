// src/main/java/com/example/demo/controller/UserInfoController.java
package com.yjq.electricitysystem.controller;

import com.yjq.electricitysystem.entity.UserInfo;
import com.yjq.electricitysystem.service.UserInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserInfoController {
    private final UserInfoService service;
    public UserInfoController(UserInfoService service) { this.service = service; }

    // 列表
    @GetMapping
    public List<UserInfo> listAll() {
        return service.listAll();
    }

//    public class UserInfoDto {
//        private Integer userCode;
//        private String userName;
//        private Integer areaCode;
//        private Integer communityCode;
//        private BigDecimal balance;
//        // getters & setters
//    }
//
//    @GetMapping("/users")
//    public List<UserInfoDto> listAll() {
//        return userService.listAll().stream()
//                .map(u -> {
//                    UserInfoDto dto = new UserInfoDto();
//                    dto.setUserCode(u.getUserCode());
//                    dto.setUserName(u.getUserName());
//                    dto.setAreaCode(u.getAreaCode());
//                    dto.setCommunityCode(u.getCommunityCode());
//                    dto.setBalance(u.getBalance());
//                    return dto;
//                })
//                .toList();
//    }

    // 单条
    @GetMapping("/{userCode}")
    public ResponseEntity<UserInfo> getOne(@PathVariable Integer userCode) {
        return service.get(userCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 新增
    @PostMapping
    public UserInfo create(@RequestBody UserInfo u) {
        return service.create(u);
    }

    // 修改
    @PutMapping("/{userCode}")
    public ResponseEntity<UserInfo> update(
            @PathVariable Integer userCode,
            @RequestBody UserInfo u
    ) {
        if (!service.get(userCode).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.update(userCode, u));
    }

    // 删除
    @DeleteMapping("/{userCode}")
    public ResponseEntity<Void> delete(@PathVariable Integer userCode) {
        if (!service.get(userCode).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.delete(userCode);
        return ResponseEntity.noContent().build();
    }
}