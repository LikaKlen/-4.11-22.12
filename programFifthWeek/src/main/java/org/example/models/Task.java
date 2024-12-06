package org.example.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "Title cannot be empty")
    private String title;

    private String body;

    private boolean completed;
}