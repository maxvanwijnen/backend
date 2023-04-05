package com.eindopdracht.eindopdracht.dto;

import com.eindopdracht.eindopdracht.model.Invoice;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class MechanicDto {
    public Long id;

    @NotBlank
    public String firstName;
    @NotBlank
    public String lastName;


    public String email;

    public Integer yearsOfExperience;
    public String specialty;

}
