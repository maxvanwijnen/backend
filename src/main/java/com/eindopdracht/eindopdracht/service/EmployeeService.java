package com.eindopdracht.eindopdracht.service;

import com.eindopdracht.eindopdracht.dto.CustomerDto;
import com.eindopdracht.eindopdracht.dto.EmployeeDto;
import com.eindopdracht.eindopdracht.exception.ResourceNotFoundException;
import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.model.Employee;
import com.eindopdracht.eindopdracht.model.Invoice;
import com.eindopdracht.eindopdracht.repository.CustomerRepository;
import com.eindopdracht.eindopdracht.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository empRepos;

    public EmployeeService(EmployeeRepository repos) {
        this.empRepos = repos;
    }

    public Long createEmployee(EmployeeDto edto) {
        Employee e = new Employee();
        e.setFirstName(edto.firstName);
        e.setLastName(edto.lastName);
        e.setEmail(edto.email);
        empRepos.save(e);

        return e.getId();
    }

 /*   public CustomerDto getCustomer(Long id) {
        Customer c = empRepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

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


      for (Invoice i : c.getInvoices()){
            cdto.invoices.add(i.getId());
        }

        return cdto;
    }

    public List getCustomers() {
        Iterable<Customer> customers = empRepos.findAll();

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
*/
/*
    public List getCustomersBySearchParams(String lastName, String postcode, String email, String phone) {
        Iterable<Customer> customers = empRepos.findByLastNameContainingOrPostcodeContainingOrEmailContainingOrPhoneContaining(lastName, postcode, email, phone);

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
    }*/
}
