package com.example.library.controller;

import com.example.library.entities.Account;
import com.example.library.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") Integer id) {
        return accountRepository.findById(id).get();
    }


    @PostMapping("")
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.saveAndFlush(account);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Integer id,
                           @RequestBody Account account) {
        account.setId(id);
        return accountRepository.saveAndFlush(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Integer id){
        accountRepository.deleteById(id);
    }
}

