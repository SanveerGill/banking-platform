package com.sanveer.banking_platform_backend.dtos.account;

import com.sanveer.banking_platform_backend.entities.User;

import java.math.BigDecimal;
import java.time.Instant;

public class CreateAccountRequest {

    private User user;
    private String accountType;
    private BigDecimal balance;

    public CreateAccountRequest(User user, String accountType, BigDecimal balance) {
        this.user = user;
        this.accountType = accountType;
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public String getAccountType() {
        return accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
