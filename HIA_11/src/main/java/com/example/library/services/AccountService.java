package com.example.library.services;
import com.example.library.entities.Account;

import java.util.List;

public interface AccountService {
    void create(Account account);
    List<Account> getAll();
    Account getById(Integer id);
    void updateUser(Integer id, Account user);
}
