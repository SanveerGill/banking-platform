package com.sanveer.banking_platform_backend.mapper;

import com.sanveer.banking_platform_backend.dtos.account.CreateAccountRequest;
import com.sanveer.banking_platform_backend.dtos.account.AccountResponse;
import com.sanveer.banking_platform_backend.entities.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account toEntity(CreateAccountRequest request);
    AccountResponse toResponse(Account account);
}
