package org.example.service;
import org.example.models.Account;
import org.example.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
    public List<Account> findByTasksId(Long taskId) {
        return accountRepository.findByTasksId(taskId);
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account createAccount(@Valid Account account) {
        return accountRepository.save(account);
    }
    public Account updateAccount(Long id, Account account) {
        account.setId(id);
        return accountRepository.save(account);
    }

    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}