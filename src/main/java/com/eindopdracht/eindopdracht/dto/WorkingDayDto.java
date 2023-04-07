package com.eindopdracht.eindopdracht.dto;

import com.eindopdracht.eindopdracht.model.Car;
import com.eindopdracht.eindopdracht.model.Orderline;
import com.eindopdracht.eindopdracht.model.WorkOrder;
import com.eindopdracht.eindopdracht.model.WorkingDay;

import java.time.LocalDate;
import java.util.List;

public class WorkingDayDto {
    public Long id;

    public List<WorkOrder> workOrders;

    public LocalDate date;
}
