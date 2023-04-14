package com.eindopdracht.eindopdracht.service;

import com.eindopdracht.eindopdracht.dto.CarDto;
import com.eindopdracht.eindopdracht.exception.DuplicateException;
import com.eindopdracht.eindopdracht.exception.ResourceNotFoundException;
import com.eindopdracht.eindopdracht.model.Car;
import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.repository.CarRepository;
import com.eindopdracht.eindopdracht.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import com.eindopdracht.eindopdracht.helper.DtoMapper;
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
        Car car = new Car();
        Customer customer = cusRepos.findById(cdto.customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        DtoMapper.mapDtoToEntity(cdto, car);
        car.setCustomer(customer);
        carRepos.save(car);

        return car.getId();
    }

    public CarDto getCar(Long id) {
        Car c = carRepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car not found"));

        CarDto cdto = new CarDto();

        cdto = DtoMapper.mapEntityToDto(cdto, c);
        cdto.customerId = c.getCustomer().getId();

        return cdto;
    }




    public List<CarDto> getCars() {
        Iterable<Car> cars = carRepos.findAll();
        if(!cars.iterator().hasNext()){
            throw new ResourceNotFoundException("No cars found, add a car first");
        }

        List<CarDto> carDtos = new ArrayList<>();

        for (Car car : cars) {

            CarDto carDto = new CarDto();

            carDto = DtoMapper.mapEntityToDto(carDto, car);
            carDto.customerId = car.getCustomer().getId();

            carDtos.add(carDto);
        }

        return carDtos;
    }






    public List getCarsBySearchParams(String licensePlate, String Brand) {

        if (licensePlate == null && Brand == null){
            throw new DuplicateException("invalid searchparameter, licendePlate and Brand are valid search parameters");
        }

        Iterable<Car> cars = carRepos.findByLicensePlateContainingOrBrandContaining(licensePlate, Brand);

        if(!cars.iterator().hasNext()){
            throw new ResourceNotFoundException("Car cannot be found, try another search query");
        }


        List<CarDto> carDtos = new ArrayList<>();

        for (Car c : cars) {
            CarDto cdto = new CarDto();
            cdto = DtoMapper.mapEntityToDto(cdto, c);
            cdto.customerId = c.getCustomer().getId();
            carDtos.add(cdto);
        }
        return carDtos;
    }
}
