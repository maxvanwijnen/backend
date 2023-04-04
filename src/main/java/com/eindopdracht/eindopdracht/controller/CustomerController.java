package com.eindopdracht.eindopdracht.controller;

import com.eindopdracht.eindopdracht.dto.CustomerDto;
import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.repository.CustomerRepository;
import com.eindopdracht.eindopdracht.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;

    }
/*    @GetMapping
    public ResponseEntity<Iterable<Customer>>getCustomers() {
        return ResponseEntity.ok(repos.findAll());
    }*/

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto cdto) {

        Long id = service.createCustomer(cdto);
        cdto.id = id;

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + id).toUriString());

        return ResponseEntity.created(uri).body(cdto);
    }

    /*@GetMapping("/city")
    public ResponseEntity<Iterable<Customer>> getCustomersByCity(@RequestParam String city) {
        return ResponseEntity.ok(repos.findByCityContainingIgnoreCase(city));
    }*/

}
