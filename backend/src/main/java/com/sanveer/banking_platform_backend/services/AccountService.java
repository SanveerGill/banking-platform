package com.sanveer.banking_platform_backend.services;

import com.sanveer.banking_platform_backend.dtos.account.CreateAccountRequest;
import com.sanveer.banking_platform_backend.dtos.account.AccountResponse;
import com.sanveer.banking_platform_backend.entities.Account;
import com.sanveer.banking_platform_backend.entities.User;
import com.sanveer.banking_platform_backend.exceptions.AccountNotFoundException;
import com.sanveer.banking_platform_backend.exceptions.UserNotFoundException;
import com.sanveer.banking_platform_backend.mapper.AccountMapper;
import com.sanveer.banking_platform_backend.repositories.AccountRepository;
import com.sanveer.banking_platform_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper, UserRepository userRepository)
    {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public AccountResponse createAccount(CreateAccountRequest request)
    {
        Long userId = request.getUserId();
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Account newAccount = this.accountMapper.toEntity(request);
        newAccount.setUser(user);
        Account savedAccount = this.accountRepository.save(newAccount);
        return this.accountMapper.toResponse(savedAccount);
    }

    public AccountResponse getAccount(Long id)
    {
        Account account = this.accountRepository.findById(id).orElseThrow(() ->  new AccountNotFoundException(id));
        return accountMapper.toResponse(account);
    }

    public List<AccountResponse> getAllAccounts()
    {
        List<Account> accounts = this.accountRepository.findAll();
        return accounts.stream().map(accountMapper::toResponse).toList();
    }

    public List<AccountResponse> getAccountsForUser(Long userId) {
        List<Account> accounts = accountRepository.findByUserId(userId).orElseThrow(() -> new AccountNotFoundException(userId));
        return accounts.stream().map(accountMapper::toResponse).toList();
    }
}
