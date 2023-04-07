package com.eindopdracht.eindopdracht.dto;

import com.eindopdracht.eindopdracht.model.Car;
import com.eindopdracht.eindopdracht.model.Orderline;
import com.eindopdracht.eindopdracht.model.WorkingDay;

import java.util.List;

public class WorkOrderDto {
    public Long id;
    public Boolean isCompleted;
    public List<Orderline> orderlines;
    public WorkingDay workingDay;
    public Car car;



}
