package com.example.Library.Management.System.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Set;

@Data
public class BookSimpleDTO {

    private Long id;

    @NotBlank
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    private int copies;

    private int rentedCopies;

    @PastOrPresent(message = "Publish date must not be in the future")
    private LocalDate publishedDate;

    private boolean borrowed;

    @NotEmpty
    @NonNull
    private Set< Long> authors;

    @NonNull
    private Long requesterId;
}