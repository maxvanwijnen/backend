package com.eindopdracht.eindopdracht.repository;

import com.eindopdracht.eindopdracht.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    Iterable<Car> findByLicensePlateContainingOrBrandContainingOrCustomerId(String licencePlate, String brand, Long customerId);
}
