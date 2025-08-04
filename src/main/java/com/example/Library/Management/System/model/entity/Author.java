package com.example.Library.Management.System.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;
@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToMany (mappedBy = "authors", fetch =  FetchType.LAZY)
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    @Column
    private int numberOfBooks;
}