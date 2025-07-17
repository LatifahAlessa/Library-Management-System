package com.example.Library.Management.System.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LibraryRequest {
    @NotBlank (message = "Library name must not be blank")
    @Size(min = 1, max = 100)
    private String name;

    @PastOrPresent(message = "Establish date must not be in the future")
    private LocalDate establishDate;
}
