package com.yjq.electricitysystem.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class PasswordChangeDto {
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @NotBlank
    private String oldPassword;
    @NotBlank
    private String newPassword;
    // getters/setters
}
