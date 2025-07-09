package com.yjq.electricitysystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebCorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")               // 拦截 /api 下的所有请求
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowCredentials(true)             // 如果要传 Cookie，就设为 true
                .maxAge(3600);                      // 预检请求的缓存时间，单位秒


    }
}
