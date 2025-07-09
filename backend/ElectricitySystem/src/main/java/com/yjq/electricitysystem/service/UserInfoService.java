package com.yjq.electricitysystem.service;

import com.yjq.electricitysystem.entity.UserInfo;
import com.yjq.electricitysystem.exception.CustomException;
import com.yjq.electricitysystem.mapper.UserInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserInfoService {

    private final UserInfoMapper userInfoMapper;

    public UserInfoService(UserInfoMapper mapper) {
        this.userInfoMapper = mapper;
    }

    public UserInfo getById(Integer userCode) {
        UserInfo u = userInfoMapper.selectByUserCode(userCode);
        if (u == null) {
            throw new CustomException("用户不存在", "404");
        }
        u.setUserPasswd(null);
        return u;
    }

    @Transactional
    public void changePassword(Integer userCode, String newPwd) {
        UserInfo u = userInfoMapper.selectByUserCode(userCode);
        if (u == null) {
            throw new CustomException("用户不存在", "404");
        }
        // 这里示例不做加密比对，若生产请用 PasswordEncoder
        userInfoMapper.updatePassword(userCode, newPwd);
    }

    public ConsumptionResult getConsumption(Integer userCode, String month) {
        Integer sum = userInfoMapper.sumConsume(userCode, month);
        if (sum == null) {
            throw new CustomException("该月无用电记录", "404");
        }
        BigDecimal cost = userInfoMapper.calcTotalCost(userCode, month);
        return new ConsumptionResult(sum, cost);
    }

    // 内部 DTO，用于消费查询结果
    public static class ConsumptionResult {
        private final Integer consumeNum;
        private final BigDecimal totalCost;
        public ConsumptionResult(Integer consumeNum, BigDecimal totalCost) {
            this.consumeNum = consumeNum;
            this.totalCost = totalCost;
        }
        public Integer getConsumeNum() { return consumeNum; }
        public BigDecimal getTotalCost() { return totalCost; }
    }

    /**
     * 普通用户登录
     * @param userInfo 前端传入的 { userCode, userPasswd }
     * @return 脱敏后的完整用户信息
     */
    public UserInfo userlogin(UserInfo userInfo) {
        Integer code = userInfo.getUserCode();
        UserInfo db = userInfoMapper.selectByUserCode(code);
        if (db == null) {
            throw new CustomException("账号不存在", "500");
        }
        if (!db.getUserPasswd().equals(userInfo.getUserPasswd())) {
            throw new CustomException("账号或密码错误", "500");
        }
        // 脱敏
        db.setUserPasswd(null);
        return db;
    }
}
