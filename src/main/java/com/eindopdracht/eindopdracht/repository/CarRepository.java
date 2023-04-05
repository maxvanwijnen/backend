package com.eindopdracht.eindopdracht.repository;

import com.eindopdracht.eindopdracht.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    Iterable<Car> findByLicensePlateContainingOrBrandContaining(String licencePlate, String Brand);
}
