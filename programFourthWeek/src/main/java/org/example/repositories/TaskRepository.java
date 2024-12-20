package org.example.repositories;
import org.example.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAccountId(Long accountId);
}