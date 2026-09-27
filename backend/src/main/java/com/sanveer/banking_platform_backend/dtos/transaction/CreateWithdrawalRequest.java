package com.sanveer.banking_platform_backend.dtos.transaction;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CreateWithdrawalRequest {

    @NotNull
    private Long accountId;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;
}
