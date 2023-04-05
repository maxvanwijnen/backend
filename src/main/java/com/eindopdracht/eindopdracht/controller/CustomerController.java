package com.eindopdracht.eindopdracht.controller;

import com.eindopdracht.eindopdracht.dto.CustomerDto;
import com.eindopdracht.eindopdracht.dto.InvoiceDto;
import com.eindopdracht.eindopdracht.service.CustomerService;
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
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService service;
    private final InvoiceService invoiceService;

    public CustomerController(CustomerService service, InvoiceService invoiceService) {
        this.service = service;

        this.invoiceService = invoiceService;
    }

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

    @GetMapping("/{id}/invoices")
    ResponseEntity<List> getInvoice(@PathVariable Long id) {

        List<InvoiceDto> idtos = invoiceService.getInvoicesBySearchParams(id);

        return ResponseEntity.ok(idtos);
    }

    @GetMapping("/search")
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

}
