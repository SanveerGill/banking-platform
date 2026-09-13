package com.sanveer.banking_platform_backend.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id)
    {
        super("User with id: " + id + " not found");
    }
}
