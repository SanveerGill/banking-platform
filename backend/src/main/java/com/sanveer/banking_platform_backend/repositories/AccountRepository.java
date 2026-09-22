package com.sanveer.banking_platform_backend.repositories;

import com.sanveer.banking_platform_backend.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<List<Account>> findByUserId(Long userId);

    boolean existsByAccountNumber(String accountNumber);
}
