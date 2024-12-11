package org.example.repositories;

import org.example.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByTasksId(Long taskId);
}