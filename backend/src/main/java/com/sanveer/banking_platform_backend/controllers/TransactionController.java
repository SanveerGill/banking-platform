package com.sanveer.banking_platform_backend.controllers;

import com.sanveer.banking_platform_backend.entities.Transaction;
import com.sanveer.banking_platform_backend.services.TransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService)
    {
        this.transactionService = transactionService;
    }
}
