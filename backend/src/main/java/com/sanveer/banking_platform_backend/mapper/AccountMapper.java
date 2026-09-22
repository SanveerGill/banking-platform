package com.sanveer.banking_platform_backend.mapper;

import com.sanveer.banking_platform_backend.dtos.account.CreateAccountRequest;
import com.sanveer.banking_platform_backend.dtos.account.AccountResponse;
import com.sanveer.banking_platform_backend.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdTimestamp", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "accountNumber", ignore = true)
    Account toEntity(CreateAccountRequest request);

    AccountResponse toResponse(Account account);
}
