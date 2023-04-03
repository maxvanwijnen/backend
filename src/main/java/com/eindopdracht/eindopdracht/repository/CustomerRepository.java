package com.eindopdracht.eindopdracht.repository;

import com.eindopdracht.eindopdracht.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Iterable<Customer> findByCityContainingIgnoreCase(String city);
}
