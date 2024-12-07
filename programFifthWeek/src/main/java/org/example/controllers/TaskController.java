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

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/create")
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{taskId}/reassign/{targetAccountId}")
    public ResponseEntity<Void> reassignTask(@PathVariable Long taskId, @PathVariable Long targetAccountId) {
        taskService.reassignTask(taskId, targetAccountId);
        return ResponseEntity.noContent().build();
    }
}