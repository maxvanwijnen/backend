package com.eindopdracht.eindopdracht.repository;


import com.eindopdracht.eindopdracht.model.Car;
import com.eindopdracht.eindopdracht.model.CarPart;
import org.springframework.data.repository.CrudRepository;

public interface CarPartRepository extends CrudRepository<CarPart, Long> {
    Iterable<CarPart> findByNameContaining(String name);

    Iterable<CarPart> findByStockAmountGreaterThan(Integer stockAmount);

    Iterable<CarPart> findByStockAmount(Integer stockAmount);


}
