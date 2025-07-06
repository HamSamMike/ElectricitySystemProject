package com.yjq.electricitysystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.entity.Admin;
import com.yjq.electricitysystem.mapper.AdminMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    public List<Admin> selectAll() {
        // 额外的业务操作需要其它的代码
        return adminMapper.selectAll();
    }

    public Admin selectByType(Integer type) {
        return adminMapper.selectByType(type);
    }

    public List<Admin> selectList(Admin admin) {
        System.out.println(admin);
        return null;
    }

    public PageInfo<Admin> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> list = adminMapper.selectAll();
        return PageInfo.of(list);
    }
}
