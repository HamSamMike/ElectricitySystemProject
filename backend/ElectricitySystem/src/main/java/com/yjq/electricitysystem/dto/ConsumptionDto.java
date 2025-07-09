package com.yjq.electricitysystem.dto;

import java.math.BigDecimal;

public class ConsumptionDto {
    public Integer getConsumeNum() {
        return consumeNum;
    }

    public void setConsumeNum(Integer consumeNum) {
        this.consumeNum = consumeNum;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    private Integer consumeNum;
    private BigDecimal totalCost;
    // getters/setters
}
