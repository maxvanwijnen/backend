package com.eindopdracht.eindopdracht.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;

public class InvoiceDto {
    public Long id;

    public Long customerId;

    public Integer totalBeforeTax;

    public Integer totalAfterTax;

    public ArrayList<String> orderLines;

    public Integer tax;
    public Boolean isPayed;




}
