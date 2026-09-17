package com.sanveer.banking_platform_backend.controllers;

import com.sanveer.banking_platform_backend.dtos.account.CreateAccountRequest;
import com.sanveer.banking_platform_backend.dtos.account.AccountResponse;
import com.sanveer.banking_platform_backend.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable Long id)
    {
        return ResponseEntity.ok(accountService.getAccount(id));
    }

    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAllAccounts()
    {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{userId}/accounts")
    public ResponseEntity<List<AccountResponse>> getAccountsForUser(@PathVariable Long userId)
    {
        return ResponseEntity.ok(accountService.getAccountsForUser(userId));
    }

    @PostMapping("/create")
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest request)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(request));
    }

}
