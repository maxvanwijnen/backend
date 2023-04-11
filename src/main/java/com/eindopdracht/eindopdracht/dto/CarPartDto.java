package com.eindopdracht.eindopdracht.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CarPartDto {
    public Long id;

    @NotBlank
    public String name;

    @NotNull
    public Integer stockAmount;


}
