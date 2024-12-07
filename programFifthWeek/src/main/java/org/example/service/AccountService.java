package org.example.service;
import jakarta.transaction.Transactional;
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

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
    }
    public List<Account> findByTasksId(Long taskId) {
        return accountRepository.findByTasksId(taskId);
    }

    @Transactional
    public Account createAccount(@Valid Account account) {
        return accountRepository.save(account);
    }

    @Transactional
    public Account updateAccount(Long id, @Valid Account accountDetails) {
        Account account = findById(id);
        account.setName(accountDetails.getName());
        account.setSurname(accountDetails.getSurname());
        account.setAge(accountDetails.getAge());
        return accountRepository.save(account);
    }

    @Transactional
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}