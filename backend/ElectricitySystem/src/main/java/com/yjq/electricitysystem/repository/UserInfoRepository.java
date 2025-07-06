// src/main/java/com/example/demo/repository/UserInfoRepository.java
package com.yjq.electricitysystem.repository;

import com.yjq.electricitysystem.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    // 如果需要按用户名查，也可以加：
    // Optional<UserInfo> findByUserName(String userName);
}