package org.example.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Добавьте имя")
    @Size(max = 100, message = "Длина имени не может быть больше 100 символов")
    private String name;
    @NotBlank(message = "Добавьте фамилию")
    @Size(max = 100, message = "Длина фамилии не может быть больше 100 символов")
    private String surname;
    @NotNull(message = "Добавьте возраст")
    @Min(value = 1, message = "Возраст не может быть отрицателен или равен нулю")
    private Integer age;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Task> tasks = new ArrayList<>();
}
