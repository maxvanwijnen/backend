package com.eindopdracht.eindopdracht.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerDto {
    public Long id;

    @NotBlank
    public String firstName;
    @NotBlank
    public String lastName;


    public String city;


    public String address;
    @Size(min = 6, max = 6)
    public String postcode;
    public String phone;

    @Email
    public String email;
}
