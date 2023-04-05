package com.eindopdracht.eindopdracht.dto;

import com.eindopdracht.eindopdracht.model.Invoice;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

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

    public List<Long> invoices = new ArrayList<>();

}
