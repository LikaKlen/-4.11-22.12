package org.example.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.models.Account;
import org.example.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.example.exceptions.AccountNotFoundException;
import javax.validation.Valid;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account findById(Long id) throws AccountNotFoundException {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id));
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