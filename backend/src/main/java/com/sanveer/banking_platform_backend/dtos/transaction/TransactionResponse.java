package com.sanveer.banking_platform_backend.dtos.transaction;

import com.sanveer.banking_platform_backend.enums.TransactionStatus;
import com.sanveer.banking_platform_backend.enums.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;

public class TransactionResponse {

    private Long transactionId;

    private Long fromAccountId;

    private Long toAccountId;

    private BigDecimal amount;

    private TransactionType type;

    private TransactionStatus status;

    private Instant createdTimestamp;

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public Instant getCreatedTimestamp() {
        return createdTimestamp;
    }
}
