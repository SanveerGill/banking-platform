package com.sanveer.banking_platform_backend.exceptions;

import java.math.BigDecimal;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(Long accountId, BigDecimal balance, BigDecimal transactionAmount)
    {
        super("Account with ID:" + accountId + " has insufficient funds for this operation. Balance: " + balance + ". Transaction Amount: " + transactionAmount);
    }
}
