package com.eindopdracht.eindopdracht.controller;

import com.eindopdracht.eindopdracht.dto.CustomerDto;
import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.repository.CustomerRepository;
import com.eindopdracht.eindopdracht.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

   @GetMapping
    ResponseEntity<List<CustomerDto>> getCustomers() {
        List<CustomerDto> cdtos = service.getCustomers();
        return ResponseEntity.ok(cdtos);
    }

    @GetMapping("/{id}")
    ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {
        CustomerDto cdto = service.getCustomer(id);

        return ResponseEntity.ok(cdto);
    }

    @GetMapping("search")
    ResponseEntity<List> getCustomersBySearchParams (
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String postcode,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone
    ) {
        List<CustomerDto> cdtos = service.getCustomersBySearchParams(lastname, postcode, email, phone);
        return ResponseEntity.ok(cdtos);
    }




    @PostMapping
    public ResponseEntity<Object> createCustomer(@Valid @RequestBody CustomerDto cdto, BindingResult br) {

        if (br.hasFieldErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage() + "\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
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
