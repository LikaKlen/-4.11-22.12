package org.example.controllers;

import org.example.models.Account;
import org.example.models.Task;
import org.example.repositories.TaskRepository;
import org.example.service.AccountService;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private AccountService accountService;

    @GetMapping("/account/{accountId}")
    public List<Task> getTasksByAccount(@PathVariable Long accountId) {
        return taskRepository.findByAccountId(accountId);
    }

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        return ResponseEntity.ok(taskService.save(task));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {

        return new ResponseEntity<>(taskService.updateTask(id,task), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reassign")
    public ResponseEntity<Void> reassignTask(@RequestParam Long taskId, @RequestParam Long targetAccountId) {
        taskService.reassignTask(taskId, targetAccountId);
        return ResponseEntity.ok().build();
    }
}