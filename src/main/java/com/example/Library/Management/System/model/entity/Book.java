package com.example.Library.Management.System.model.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.*;
import java.util.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 100)
    private String title;

    @Column
    private int copies;

    @Column
    private int rentedCopies;

    @Column
    private LocalDate publishedDate;

    @Column
    private boolean borrowed;

    //User
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (
            name = "book_user",
            joinColumns = @JoinColumn (name = "book_id"),
            inverseJoinColumns = @JoinColumn (name = "user_id")
    )
    private List<User> borrowers = new ArrayList<>();

    //Library
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (
            name = "book_library",
            joinColumns = @JoinColumn (name = "book_id"),
            inverseJoinColumns = @JoinColumn (name = "library_id")
    )
    private List<Library> libraries = new ArrayList<>();

    //Author
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (
            name = "book_author",
            joinColumns = @JoinColumn (name = "book_id"),
            inverseJoinColumns = @JoinColumn (name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();
}
