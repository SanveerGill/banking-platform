package com.sanveer.banking_platform_backend.dtos.account;

import java.math.BigDecimal;

public class CreateAccountRequest {

    private final Long userId;
    private final String accountType;
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
