package com.eindopdracht.eindopdracht.service;

import com.eindopdracht.eindopdracht.dto.CarDto;
import com.eindopdracht.eindopdracht.dto.CustomerDto;
import com.eindopdracht.eindopdracht.exception.ResourceNotFoundException;
import com.eindopdracht.eindopdracht.model.Car;
import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.model.Invoice;
import com.eindopdracht.eindopdracht.repository.CarRepository;
import com.eindopdracht.eindopdracht.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepos;
    private final CustomerRepository cusRepos;

    public CarService(CarRepository carRepos, CustomerRepository cusRepos) {
        this.carRepos = carRepos;
        this.cusRepos = cusRepos;
    }

    public Long createCar(CarDto cdto) {
        Car c = new Car();
        Customer customer = cusRepos.findById(cdto.customerId).get();
        c.setBrand(cdto.brand);
        c.setModel(cdto.model);
        c.setColor(cdto.color);
        c.setYear(cdto.year);
        c.setLicensePlate(cdto.licensePlate);
        c.setCustomer(customer);

        carRepos.save(c);

        return c.getId();
    }

    public CarDto getCar(Long id) {
        Car c = carRepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car not found"));

        CarDto cdto = new CarDto();
        cdto.id = c.getId();
        cdto.brand = c.getBrand();
        cdto.model = c.getModel();
        cdto.color = c.getColor();
        cdto.year = c.getYear();
        cdto.customerId = c.getCustomer().getId();
        cdto.lastCheck = c.getLastCheck();
        cdto.numberOfDoors = c.getNumberOfDoors();
        cdto.licensePlate = c.getLicensePlate();
        cdto.transmission = c.getTransmission();

/*
tedoen workorders moeten hier straks in een loopje worden opgehaald
      for (Invoice i : c.getCars()){
            cdto.invoices.add(i.getId());
        }*/

        return cdto;
    }

    public List getCars() {
        Iterable<Car> cars = carRepos.findAll();

        List<CarDto> carDtos = new ArrayList<>();
        for (Car c : cars) {
            CarDto cdto = new CarDto();
            cdto.id = c.getId();
            cdto.brand = c.getBrand();
            cdto.model = c.getModel();
            cdto.color = c.getColor();
            cdto.year = c.getYear();
            cdto.customerId = c.getCustomer().getId();
            cdto.lastCheck = c.getLastCheck();
            cdto.numberOfDoors = c.getNumberOfDoors();
            cdto.licensePlate = c.getLicensePlate();
            cdto.transmission = c.getTransmission();

            carDtos.add(cdto);
        }
        return carDtos;
    }


    public List getCarsBySearchParams(String licensePlate, String brand, Long customerId) {
        Iterable<Car> cars = carRepos.findByLicensePlateContainingOrBrandContainingOrCustomerId(licensePlate, brand, customerId);

        List<CarDto> carDtos = new ArrayList<>();

        for (Car c : cars) {
            CarDto cdto = new CarDto();
            cdto.id = c.getId();
            cdto.brand = c.getBrand();
            cdto.model = c.getModel();
            cdto.color = c.getColor();
            cdto.year = c.getYear();
            cdto.customerId = c.getCustomer().getId();
            cdto.lastCheck = c.getLastCheck();
            cdto.numberOfDoors = c.getNumberOfDoors();
            cdto.licensePlate = c.getLicensePlate();
            cdto.transmission = c.getTransmission();
            carDtos.add(cdto);
        }
        return carDtos;
    }
}
