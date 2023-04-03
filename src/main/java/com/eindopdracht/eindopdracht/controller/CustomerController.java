package com.eindopdracht.eindopdracht.controller;

import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    CustomerRepository repos;
    @GetMapping
    public ResponseEntity<Iterable<Customer>>getCustomers() {
        return ResponseEntity.ok(repos.findAll());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer c) {
        repos.save(c);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/"+ c.getId()).toUriString());

        return ResponseEntity.created(uri).body(c);
    }

    @GetMapping("/city")
    public ResponseEntity<Iterable<Customer>> getCustomersByCity(@RequestParam String city) {
        return ResponseEntity.ok(repos.findByCityContainingIgnoreCase(city));
    }

}
