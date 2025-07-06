// src/main/java/com/example/demo/service/UserInfoService.java
package com.yjq.electricitysystem.service;

import com.yjq.electricitysystem.entity.UserInfo;
import com.yjq.electricitysystem.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {
    private final UserInfoRepository repo;
    public UserInfoService(UserInfoRepository repo) { this.repo = repo; }

    public List<UserInfo> listAll() { return repo.findAll(); }
    public Optional<UserInfo> get(Integer code) { return repo.findById(code); }
    public UserInfo create(UserInfo u) { return repo.save(u); }
    public UserInfo update(Integer code, UserInfo u) {
        u.setUserCode(code);
        return repo.save(u);
    }
    public void delete(Integer code) { repo.deleteById(code); }
}