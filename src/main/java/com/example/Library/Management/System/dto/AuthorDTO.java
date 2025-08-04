package com.example.Library.Management.System.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthorDTO {

    private Long id;

    @NotBlank
    @Size(max = 20, message = "First name must be at most 20 characters")
    private String firstName;

    @NotBlank
    @Size(max = 20, message = "Last name must be at most 20 characters")
    private String lastName;

    @PositiveOrZero (message = "Number of books must be 0 or more")
    private int numberOfBooks;
}
