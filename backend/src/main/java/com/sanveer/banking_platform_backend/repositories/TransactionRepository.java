package com.sanveer.banking_platform_backend.repositories;

import com.sanveer.banking_platform_backend.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
