package com.sanveer.banking_platform_backend.exceptions;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(Long id) {
        super("The transaction with id: " + id + " does not exist.");
    }
}
