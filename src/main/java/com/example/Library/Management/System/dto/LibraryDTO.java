package com.example.Library.Management.System.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class LibraryDTO {

    private Long id;

    @NotBlank (message = "Library name must not be blank")
    @Size(min = 1, max = 100, message = "Library name must have at least 1 character and not more than 100")
    private String name;

    private int numberOfAvailableBooks;

    @PastOrPresent(message = "Establish date must not be in the future")
    private LocalDate establishDate;

    private UserDTO manager;

    private List<BookDTO> books;
}
