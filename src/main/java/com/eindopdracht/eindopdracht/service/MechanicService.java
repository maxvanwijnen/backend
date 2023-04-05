package com.eindopdracht.eindopdracht.service;

import com.eindopdracht.eindopdracht.dto.EmployeeDto;
import com.eindopdracht.eindopdracht.dto.MechanicDto;
import com.eindopdracht.eindopdracht.model.Employee;
import com.eindopdracht.eindopdracht.model.Mechanic;
import com.eindopdracht.eindopdracht.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class MechanicService {

    private final EmployeeRepository empRepos;

    public MechanicService(EmployeeRepository repos) {
        this.empRepos = repos;
    }

    public Long createMechanic(MechanicDto mdto) {
        Mechanic m = new Mechanic();
        m.setFirstName(mdto.firstName);
        m.setLastName(mdto.lastName);
        m.setEmail(mdto.email);
        m.setSpecialty(mdto.specialty);
        m.setYearsOfExperience(mdto.yearsOfExperience);

        empRepos.save(m);

        return m.getId();
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
