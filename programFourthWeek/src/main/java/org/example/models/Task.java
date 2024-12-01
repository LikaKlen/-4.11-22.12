package org.example.models;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    private String title;
    private String body;
    private Boolean completed;
}