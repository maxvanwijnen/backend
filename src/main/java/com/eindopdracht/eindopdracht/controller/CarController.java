package com.eindopdracht.eindopdracht.controller;

import com.eindopdracht.eindopdracht.dto.CarDto;
import com.eindopdracht.eindopdracht.dto.CustomerDto;
import com.eindopdracht.eindopdracht.dto.InvoiceDto;
import com.eindopdracht.eindopdracht.service.CarService;
import com.eindopdracht.eindopdracht.service.InvoiceService;
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
@RequestMapping("cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService service) {
        this.carService = service;

    }

    @GetMapping
    ResponseEntity<List<CarDto>> getCars() {
        List<CarDto> cdtos = carService.getCars();
        return ResponseEntity.ok(cdtos);
    }

    @GetMapping("/{id}")
    ResponseEntity<CarDto> getInvoice(@PathVariable Long id) {
        CarDto cdto = carService.getCar(id);

        return ResponseEntity.ok(cdto);
    }



    @PostMapping
    public ResponseEntity<Object> createCar(@Valid @RequestBody CarDto cdto, BindingResult br) {

        if (br.hasFieldErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage() + "\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        Long id = carService.createCar(cdto);
        cdto.id = id;

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + id).toUriString());

        return ResponseEntity.created(uri).body(cdto);
    }



    @GetMapping("/search")
    ResponseEntity<List> getCarsBySearchParams (
            @RequestParam(required = false) String licensePlate,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Long customerId
    ) {
        List<CarDto> cdtos = carService.getCarsBySearchParams(licensePlate, brand, customerId);
        return ResponseEntity.ok(cdtos);
    }





/*    @PostMapping
    public ResponseEntity<Object> createCustomer(@Valid @RequestBody CustomerDto cdto, BindingResult br) {

        if (br.hasFieldErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage() + "\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        Long id = service.createInvoice(idto);
        cdto.id = id;

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + id).toUriString());

        return ResponseEntity.created(uri).body(cdto);
    }*/

}
