package com.eindopdracht.eindopdracht.dto;

import jakarta.validation.constraints.NotBlank;

public class EmployeeDto {
    public Long id;

    @NotBlank
    public String firstName;
    @NotBlank
    public String lastName;

    public String email;


}
