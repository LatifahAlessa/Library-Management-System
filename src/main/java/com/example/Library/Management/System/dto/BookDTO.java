package com.example.Library.Management.System.dto;

import com.example.Library.Management.System.model.entity.Author;
import com.example.Library.Management.System.model.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookDTO {

    private Long id;

    @NotBlank
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    private int copies;

    private int rentedCopies;

    @PastOrPresent(message = "Publish date must not be in the future")
    private LocalDate publishedDate;

    private boolean borrowed;

    private List<Author> authors;

    private List<User> borrowers;
}