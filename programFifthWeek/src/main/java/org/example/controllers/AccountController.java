package org.example.controllers;


import lombok.RequiredArgsConstructor;
import org.example.models.Account;
import org.example.models.Task;
import org.example.repositories.AccountRepository;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }


    @GetMapping("/task/{taskId}")
    public List<Account> getAccountsByTask(@PathVariable Long taskId) {
        return accountService.findByTasksId(taskId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @Valid @RequestBody Account account) {
        return new ResponseEntity<>(accountService.updateAccount(id, account), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}