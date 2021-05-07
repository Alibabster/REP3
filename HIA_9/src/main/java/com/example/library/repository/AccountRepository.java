package com.example.library.repository;

import com.example.library.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account getById(Integer id);
}
