package com.eindopdracht.eindopdracht.service;

import com.eindopdracht.eindopdracht.dto.CustomerDto;
import com.eindopdracht.eindopdracht.exception.ResourceNotFoundException;
import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repos;

    public CustomerService(CustomerRepository repos) {
        this.repos = repos;
    }

    public Long createCustomer(CustomerDto cdto) {
        Customer c = new Customer();
        c.setFirstName(cdto.firstName);
        c.setLastName(cdto.lastName);
        c.setEmail(cdto.email);
        c.setAddress(cdto.address);
        c.setCity(cdto.city);
        c.setPostcode(cdto.postcode);
        c.setPhone(cdto.phone);

        repos.save(c);

        return c.getId();
    }

    public CustomerDto getCustomer(Long id) {
        Customer c = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        CustomerDto cdto = new CustomerDto();
        cdto.id = c.getId();
        cdto.firstName = c.getFirstName();
        cdto.lastName = c.getLastName();
        cdto.city = c.getCity();
        cdto.email = c.getEmail();
        cdto.city = c.getCity();
        cdto.address = c.getAddress();
        cdto.phone = c.getPhone();
        cdto.postcode = c.getPostcode();

        return cdto;
    }

    public List getCustomers() {
        Iterable<Customer> customers = repos.findAll();

        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer c : customers) {
            CustomerDto cdto = new CustomerDto();
            cdto.id = c.getId();
            cdto.firstName = c.getFirstName();
            cdto.lastName = c.getLastName();
            cdto.city = c.getCity();
            cdto.email = c.getEmail();
            cdto.city = c.getCity();
            cdto.address = c.getAddress();
            cdto.phone = c.getPhone();
            cdto.postcode = c.getPostcode();
            customerDtos.add(cdto);
        }
        return customerDtos;
    }


    public List getCustomersBySearchParams(String lastName, String postcode, String email, String phone) {
        Iterable<Customer> customers = repos.findByLastNameContainingOrPostcodeContainingOrEmailContainingOrPhoneContaining(lastName, postcode, email, phone);

        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer c : customers) {
            CustomerDto cdto = new CustomerDto();
            cdto.id = c.getId();
            cdto.firstName = c.getFirstName();
            cdto.lastName = c.getLastName();
            cdto.city = c.getCity();
            cdto.email = c.getEmail();
            cdto.city = c.getCity();
            cdto.address = c.getAddress();
            cdto.phone = c.getPhone();
            cdto.postcode = c.getPostcode();
            customerDtos.add(cdto);
        }
        return customerDtos;
    }
}
