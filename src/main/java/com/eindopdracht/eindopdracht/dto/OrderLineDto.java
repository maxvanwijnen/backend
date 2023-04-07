package com.eindopdracht.eindopdracht.dto;

import com.eindopdracht.eindopdracht.model.Car;
import com.eindopdracht.eindopdracht.model.CarPart;
import com.eindopdracht.eindopdracht.model.Orderline;
import com.eindopdracht.eindopdracht.model.WorkingDay;

import java.util.List;

public class OrderLineDto {
    public Long id;
    public String description;

    public CarPart carPart;

    public Integer costs;

}
