package com.sanveer.banking_platform_backend.mapper;

import com.sanveer.banking_platform_backend.dtos.user.CreateUserRequest;
import com.sanveer.banking_platform_backend.dtos.user.CreateUserResponse;
import com.sanveer.banking_platform_backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdTimestamp", ignore = true)
    User toEntity(CreateUserRequest request);

    CreateUserResponse toResponse(User user);
}