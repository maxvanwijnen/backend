package com.eindopdracht.eindopdracht.repository;

import com.eindopdracht.eindopdracht.model.WorkOrder;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface WorkOrderRepository extends CrudRepository<WorkOrder, Long> {
    /*Optional<WorkOrder> findByWorkingDate(Integer workingDayId);*/
}
