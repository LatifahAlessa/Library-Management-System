package com.example.Library.Management.System.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.*;
import java.util.*;

@Entity
@Data
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Manager manager;*/

    @Column
    private LocalDate establishDate;

    /*@OneToMany (mappedBy = "library", cascade = CascadeType.ALL)
    private Set<Book> books;*/
}

