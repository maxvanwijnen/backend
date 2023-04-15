package com.eindopdracht.eindopdracht.controller;

import com.eindopdracht.eindopdracht.dto.CarDto;
import com.eindopdracht.eindopdracht.dto.CarPartDto;
import com.eindopdracht.eindopdracht.service.CarPartService;
import com.eindopdracht.eindopdracht.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("carparts")
public class CarPartController {

    private final CarPartService cpService;

    public CarPartController(CarPartService cpService) {
        this.cpService = cpService;

    }

    @GetMapping
    ResponseEntity<List<CarPartDto>> getCarParts() {
        List<CarPartDto> cdtos = cpService.getCarParts();
        return ResponseEntity.ok(cdtos);
    }

    @GetMapping("/{id}")
    ResponseEntity<CarPartDto> getCarPart(@PathVariable Long id) {
        CarPartDto cpdto = cpService.getCarPart(id);

        return ResponseEntity.ok(cpdto);
    }

    @GetMapping("/search")
    ResponseEntity<List> getCarPartsBySearchParams (
            @RequestParam(required = false) Integer stock,
            @RequestParam(required = false) String name
    ) {
        List<CarPartDto> cpdtos = cpService.getCarPartsBySearchParams(stock, name);
        return ResponseEntity.ok(cpdtos);
    }



    @PostMapping
    public ResponseEntity<Object> createCarPart(@Valid @RequestBody CarPartDto cdto, BindingResult br) {

        if (br.hasFieldErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage() + "\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        Long id = cpService.createCarPart(cdto);
        cdto.id = id;

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + id).toUriString());

        return ResponseEntity.created(uri).body(cdto);
    }




}
