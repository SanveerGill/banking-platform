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

    private TransactionType transactionType;

    private TransactionStatus transactionStatus;

    private Instant createdTimestamp;

    public TransactionResponse(
            Long transactionId,
            Long fromAccountId,
            Long toAccountId,
            BigDecimal amount,
            TransactionType transactionType,
            TransactionStatus transactionStatus,
            Instant createdTimestamp) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
        this.createdTimestamp = createdTimestamp;
    }

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

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public Instant getCreatedTimestamp() {
        return createdTimestamp;
    }
}
