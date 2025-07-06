package com.yjq.electricitysystem.controller;

import com.yjq.electricitysystem.dto.LoginRequest;
import com.yjq.electricitysystem.dto.JwtResponse;
import com.yjq.electricitysystem.entity.UserInfo;
import com.yjq.electricitysystem.service.UserInfoService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

    @Autowired
    private UserInfoService userService;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpirationMs;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        // 1. 根据用户码查库
        Optional<UserInfo> opt = userService.get(req.getUserCode());

        // 把配置文件里的字符串 secret 转成字节
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        // 如果想要更安全，secret 最少 256-bit 长度，即至少 32 个字符
        Key key = Keys.hmacShaKeyFor(keyBytes);

        // 2. 校验密码
        if (opt.isPresent() && opt.get().getUserPasswd().equals(req.getUserPasswd())) {
            UserInfo u = opt.get();
            String token = Jwts.builder()
                    .setSubject(u.getUserCode().toString())
                    .claim("userName", u.getUserName())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                    .signWith(key,SignatureAlgorithm.HS512)
                    .compact();
            // 成功返回 JwtResponse
            return ResponseEntity.ok(new JwtResponse(token, u.getUserName()));
        }

        // 3. 不通过返回 401 + 错误消息
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("账号或密码错误");
    }

}
