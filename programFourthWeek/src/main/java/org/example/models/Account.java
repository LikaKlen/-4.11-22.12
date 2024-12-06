package org.example.models;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import javax.validation.constraints.*;
@Entity
@Data
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String name;
    private String surname;
    private Integer age;
}