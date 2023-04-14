package com.eindopdracht.eindopdracht.dto;

import com.eindopdracht.eindopdracht.model.Customer;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarDto {
    public Long id;


    @NotBlank
    public String licensePlate;
    @NotBlank
    public String brand;

    @NotBlank
    public String model;
    public String color;
    public Integer numberOfDoors;
    public String transmission;
    public LocalDate year;

    public LocalDate lastCheck;

    public Long customerId;


}
