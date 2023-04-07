package com.eindopdracht.eindopdracht.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class CarPartDto {
    public Long id;

    @NotBlank
    public String name;

    @NotBlank
    public Integer stockAmount;


}
