package org.example.service;
import org.example.models.Account;
import org.example.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
    public Account updateAccount(Long id, Account account) {
        account.setId(id);
        return accountRepository.save(account);
    }
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}