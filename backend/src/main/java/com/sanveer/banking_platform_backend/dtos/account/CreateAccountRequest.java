package com.sanveer.banking_platform_backend.dtos.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CreateAccountRequest {

    @NotNull
    private final Long userId;

    @NotBlank
    private final String accountType;

    @NotNull
    private final BigDecimal balance;

    public CreateAccountRequest(Long userId, String accountType, BigDecimal balance) {
        this.userId = userId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Long getUserId() {
        return userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
