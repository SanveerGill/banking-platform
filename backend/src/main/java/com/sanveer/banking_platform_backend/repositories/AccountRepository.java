package com.sanveer.banking_platform_backend.repositories;

import com.sanveer.banking_platform_backend.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
