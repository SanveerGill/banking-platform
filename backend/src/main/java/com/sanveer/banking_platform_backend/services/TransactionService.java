package com.sanveer.banking_platform_backend.services;

import com.sanveer.banking_platform_backend.dtos.transaction.CreateDepositRequest;
import com.sanveer.banking_platform_backend.dtos.transaction.CreateTransferRequest;
import com.sanveer.banking_platform_backend.dtos.transaction.CreateWithdrawalRequest;
import com.sanveer.banking_platform_backend.dtos.transaction.TransactionResponse;
import com.sanveer.banking_platform_backend.entities.Account;
import com.sanveer.banking_platform_backend.entities.Transaction;
import com.sanveer.banking_platform_backend.enums.TransactionStatus;
import com.sanveer.banking_platform_backend.enums.TransactionType;
import com.sanveer.banking_platform_backend.exceptions.AccountNotFoundException;
import com.sanveer.banking_platform_backend.exceptions.InsufficientFundsException;
import com.sanveer.banking_platform_backend.exceptions.TransactionNotFoundException;
import com.sanveer.banking_platform_backend.mapper.TransactionMapper;
import com.sanveer.banking_platform_backend.repositories.AccountRepository;
import com.sanveer.banking_platform_backend.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.transactionMapper = transactionMapper;
    }

    @Transactional
    public TransactionResponse transferMoney(CreateTransferRequest request)
    {
        Long fromAccountId = request.getFromAccountId();
        Long toAccountId = request.getToAccountId();
        if (fromAccountId.equals(toAccountId)) {
            throw new IllegalArgumentException("Source and destination accounts cannot be the same");
        }
        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow(() -> new AccountNotFoundException(fromAccountId));
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow(() -> new AccountNotFoundException(toAccountId));
        BigDecimal fromAccountBalance = fromAccount.getBalance();
        BigDecimal requestAmount = request.getAmount();
        if (fromAccountBalance.compareTo(requestAmount) < 0) {
            throw new InsufficientFundsException(fromAccountId, fromAccountBalance, requestAmount);
        }
        fromAccount.setBalance(fromAccount.getBalance().subtract(request.getAmount()));
        toAccount.setBalance(toAccount.getBalance().add(request.getAmount()));
        Transaction transaction = transactionMapper.toEntity(request);
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setTransactionType(TransactionType.TRANSFER);
        transaction.setTransactionStatus(TransactionStatus.COMPLETED);
        transactionRepository.save(transaction);
        return transactionMapper.toResponse(transaction);
    }

    @Transactional
    public TransactionResponse depositMoney(CreateDepositRequest request) {
        Long accountId = request.getAccountId();
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
        account.setBalance(account.getBalance().add(request.getAmount()));
        Transaction transaction = transactionMapper.toEntity(request);
        transaction.setToAccount(account);
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setTransactionStatus(TransactionStatus.COMPLETED);
        transactionRepository.save(transaction);
        return transactionMapper.toResponse(transaction);
    }

    @Transactional
    public TransactionResponse withdrawMoney(CreateWithdrawalRequest request) {
        Long accountId = request.getAccountId();
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
        BigDecimal withdrawalAmount = request.getAmount();
        BigDecimal accountBalance = account.getBalance();
        if (withdrawalAmount.compareTo(accountBalance) > 0)
        {
            throw new InsufficientFundsException(accountId, accountBalance, withdrawalAmount);
        }
        account.setBalance(accountBalance.subtract(withdrawalAmount));
        Transaction transaction = transactionMapper.toEntity(request);
        transaction.setFromAccount(account);
        transaction.setTransactionStatus(TransactionStatus.COMPLETED);
        transaction.setTransactionType(TransactionType.WITHDRAWAL);
        transactionRepository.save(transaction);
        return transactionMapper.toResponse(transaction);
    }

    public TransactionResponse getTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException(id));
        return transactionMapper.toResponse(transaction);
    }
}
