package com.sanveer.banking_platform_backend.dtos.account;

import com.sanveer.banking_platform_backend.entities.User;

import java.math.BigDecimal;
import java.time.Instant;

public class CreateAccountResponse {

    private final Long userId;
    private final String accountNumber;
    private final String accountType;
    private final BigDecimal balance;
    private final Instant createdTimestamp;

    public CreateAccountResponse(Long userId, String accountNumber, String accountType, BigDecimal balance, Instant createdTimestamp) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.createdTimestamp = createdTimestamp;
    }

    public Long getUserId() {
        return userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Instant getCreatedTimestamp() {
        return createdTimestamp;
    }
}
