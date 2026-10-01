package com.sanveer.banking_platform_backend.controllers;

import com.sanveer.banking_platform_backend.dtos.transaction.CreateDepositRequest;
import com.sanveer.banking_platform_backend.dtos.transaction.CreateTransferRequest;
import com.sanveer.banking_platform_backend.dtos.transaction.CreateWithdrawalRequest;
import com.sanveer.banking_platform_backend.dtos.transaction.TransactionResponse;
import com.sanveer.banking_platform_backend.entities.Transaction;
import com.sanveer.banking_platform_backend.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransactionResponse> transferMoney(@Valid @RequestBody CreateTransferRequest request) {
        return ResponseEntity.ok(transactionService.transferMoney(request));
    }

    @PostMapping("/deposit")
    public ResponseEntity<TransactionResponse> depositMoney(@Valid @RequestBody CreateDepositRequest request) {
        return ResponseEntity.ok(transactionService.depositMoney(request));
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<TransactionResponse> withdrawMoney(@Valid @RequestBody CreateWithdrawalRequest request) {
        return ResponseEntity.ok(transactionService.withdrawMoney(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> getTransaction(@PathVariable Long id)
    {
        return ResponseEntity.ok(transactionService.getTransaction(id));
    }
}
