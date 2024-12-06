package org.example.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;
    @NotBlank(message = "Добавьте название данной задачи")
    private String title;
    @NotBlank(message = "Добавьте описание задачи")
    private String body;
    @NotNull(message = "Добавьте статус")
    private Boolean completed;
}
