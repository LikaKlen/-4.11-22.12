package org.example.service;
import jakarta.transaction.Transactional;
import org.example.models.Account;
import org.example.models.Task;
import org.example.repositories.AccountRepository;
import org.example.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class TaskService {

        @Autowired
        private TaskRepository taskRepository;

        @Autowired
        private AccountRepository accountRepository;

        public Task save(@Valid Task task) {
            return taskRepository.save(task);
        }
        public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setId(existingTask.getId());
        return taskRepository.save(task);
        }

        public void delete(Long id) {
            taskRepository.deleteById(id);
        }

        @Transactional
        public void reassignTask(Long taskId, Long targetAccountId) {
            Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
            Account targetAccount = accountRepository.findById(targetAccountId).orElseThrow(() -> new RuntimeException("Target account not found"));

            if (task.getAccount().getId().equals(targetAccount.getId())) {
                throw new RuntimeException("Task is already assigned to this account");
            }

            task.setAccount(targetAccount);
            taskRepository.save(task);
        }
}