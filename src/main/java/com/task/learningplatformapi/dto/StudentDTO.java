package com.task.learningplatformapi.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class StudentDTO {

    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String address;

    @NotBlank
    private String phoneNumber;

    @NotNull
    private LocalDate dob;

    @NotBlank
    @Email
    private String email;
}
