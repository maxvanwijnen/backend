package com.eindopdracht.eindopdracht.service;

import com.eindopdracht.eindopdracht.dto.CustomerDto;
import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.repository.CustomerRepository;
import org.springframework.stereotype.Service;

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
}
