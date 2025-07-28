package com.example.Library.Management.System.model.entity;
import com.example.Library.Management.System.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Data;
import java.time.*;

@Entity
@Table (name = "app_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 20, nullable = false)
    private String firstName;

    @Column (length = 20, nullable = false)
    private String lastName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Column
    private LocalDate employmentDate;

    @OneToOne (mappedBy = "user")
    private Library library;
}
