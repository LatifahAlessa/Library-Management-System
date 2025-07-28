package com.example.Library.Management.System.dto;
import com.example.Library.Management.System.enums.RoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UserDTO {

    private Long id;

    @NotBlank
    @Size(max = 20, message = "First name must be at most 20 characters")
    private String firstName;

    @NotBlank
    @Size(max = 20, message = "Last name must be at most 20 characters")
    private String lastName;

    private RoleEnum role;

    @PastOrPresent (message = "Employment date must not be in the future")
    private LocalDate employmentDate;
}
