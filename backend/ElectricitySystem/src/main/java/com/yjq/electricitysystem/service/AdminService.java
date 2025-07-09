package com.yjq.electricitysystem.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjq.electricitysystem.entity.Admin;
import com.yjq.electricitysystem.exception.CustomException;
import com.yjq.electricitysystem.mapper.AdminMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    private static final Integer TYPE_ADMIN01 = 1;
    private static final Integer TYPE_ADMIN02 = 2;

    public Admin admin01login(Admin admin) {
        Integer code = admin.getAdminCode();
        Admin db = adminMapper.selecrByadmincode(code);
        if (db == null) {
            throw new CustomException("账号不存在", "500");
        }
        // 类型校验
        if (!TYPE_ADMIN01.equals(db.getAdminType())) {
            throw new CustomException("不是 01 类型管理员", "403");
        }
        // 密码校验
        if (!db.getAdminPasswd().equals(admin.getAdminPasswd())) {
            throw new CustomException("账号或密码错误", "500");
        }
        // 登录成功，屏蔽密码字段
        db.setAdminPasswd(null);
        return db;
    }

    public Admin admin02login(Admin admin) {
        Integer code = admin.getAdminCode();
        Admin db = adminMapper.selecrByadmincode(code);
        if (db == null) {
            throw new CustomException("账号不存在", "500");
        }
        if (!TYPE_ADMIN02.equals(db.getAdminType())) {
            throw new CustomException("不是 02 类型管理员", "403");
        }
        if (!db.getAdminPasswd().equals(admin.getAdminPasswd())) {
            throw new CustomException("账号或密码错误", "500");
        }
        db.setAdminPasswd(null);
        return db;
    }

    public List<Admin> selectAll() {
        // 额外的业务操作需要其它的代码
        return adminMapper.selectAll();
    }

    public void add(Admin admin) {
        adminMapper.insert(admin);
    }

    public void update(Admin admin) {
        adminMapper.updateById(admin);
    }

    public void deleteById(Integer code) {
        adminMapper.deleteById(code);
    }

    public Admin selectByType(Integer type) {
        return adminMapper.selectByType(type);
    }

    public List<Admin> selectList(Admin admin) {
        //System.out.println(admin);
        return null;
    }

    public PageInfo<Admin> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> list = adminMapper.selectAll();
        return PageInfo.of(list);
    }


}
