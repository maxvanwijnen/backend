package com.eindopdracht.eindopdracht.service;

import com.eindopdracht.eindopdracht.dto.CarDto;
import com.eindopdracht.eindopdracht.dto.CarPartDto;
import com.eindopdracht.eindopdracht.model.Car;
import com.eindopdracht.eindopdracht.model.CarPart;
import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.repository.CarPartRepository;
import com.eindopdracht.eindopdracht.repository.CarRepository;
import com.eindopdracht.eindopdracht.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarPartService {

    private final CarPartRepository carPartRepos;

    public CarPartService(CarPartRepository carPartRepos) {
        this.carPartRepos = carPartRepos;
    }






    public Long createCarPart(CarPartDto cdto) {
        CarPart c = new CarPart();

        c.setName(cdto.name);
        c.setStockAmount(cdto.stockAmount);

        carPartRepos.save(c);

        return c.getId();
    }

    public List getCarParts() {
        Iterable<CarPart> carParts = carPartRepos.findAll();
        List<CarPartDto> carPartDtos = new ArrayList<>();
        for (CarPart c : carParts) {
            CarPartDto cdto = new CarPartDto();
            cdto.id = c.getId();
            cdto.name = c.getName();
            cdto.stockAmount = c.getStockAmount();

            carPartDtos.add(cdto);
        }
        return carPartDtos;
    }

    public List getCarPartsBySearchParams(String name, Integer stockAmount, String GreaterOrLess) {

        Iterable<CarPart> carParts;

        if (stockAmount == null){
            carParts = carPartRepos.findByNameContaining(name);
        }
        else {
            if (GreaterOrLess == ">"){
                carParts = carPartRepos.findByStockAmountGreaterThan(stockAmount);
            }
            else if (GreaterOrLess == "<"){
                carParts = carPartRepos.findByStockAmountGreaterThan(stockAmount);
            }
            else {
                carParts = carPartRepos.findByStockAmount(stockAmount);
            }
        }




        List<CarPartDto> carPartDtos = new ArrayList<>();

        for (CarPart c : carParts) {
            CarPartDto cdto = new CarPartDto();
            cdto.id = c.getId();
            cdto.name = c.getName();
            cdto.stockAmount = c.getStockAmount();
            carPartDtos.add(cdto);
        }
        return carPartDtos;
    }



}
