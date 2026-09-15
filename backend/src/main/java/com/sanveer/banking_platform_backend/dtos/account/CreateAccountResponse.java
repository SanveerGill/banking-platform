package com.sanveer.banking_platform_backend.dtos.account;

import com.sanveer.banking_platform_backend.entities.User;

import java.math.BigDecimal;
import java.time.Instant;

public class CreateAccountResponse {

    private User user;
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private Instant createdTimestamp;

    public CreateAccountResponse(User user, String accountNumber, String accountType, BigDecimal balance, Instant createdTimestamp) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.createdTimestamp = createdTimestamp;
    }

    public User getUser() {
        return user;
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
