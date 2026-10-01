package com.sanveer.banking_platform_backend.repositories;

import com.sanveer.banking_platform_backend.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByFromAccountId(Long fromAccountId);

    List<Transaction> findAllByToAccountId(Long toAccountId);

    List<Transaction> findAllByFromAccountIdOrToAccountIdOrderByCreatedTimestampDesc(Long fromAccountId, Long toAccountId);
}
