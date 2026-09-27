package com.sanveer.banking_platform_backend.mapper;

import com.sanveer.banking_platform_backend.dtos.transaction.CreateDepositRequest;
import com.sanveer.banking_platform_backend.dtos.transaction.CreateTransferRequest;
import com.sanveer.banking_platform_backend.dtos.transaction.CreateWithdrawalRequest;
import com.sanveer.banking_platform_backend.dtos.transaction.TransactionResponse;
import com.sanveer.banking_platform_backend.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TransactionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdTimestamp", ignore = true)
    @Mapping(target = "fromAccount", ignore = true)
    @Mapping(target = "toAccount", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "status", ignore = true)
    Transaction toEntity(CreateTransferRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdTimestamp", ignore = true)
    @Mapping(target = "fromAccount", ignore = true)
    @Mapping(target = "toAccount", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "status", ignore = true)
    Transaction toEntity(CreateDepositRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdTimestamp", ignore = true)
    @Mapping(target = "fromAccount", ignore = true)
    @Mapping(target = "toAccount", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "status", ignore = true)
    Transaction toEntity(CreateWithdrawalRequest request);

    @Mapping(source = "id", target = "transactionId")
    @Mapping(source = "fromAccount.id", target = "fromAccountId")
    @Mapping(source = "toAccount.id", target = "toAccountId")
    TransactionResponse toResponse(Transaction transaction);
}
