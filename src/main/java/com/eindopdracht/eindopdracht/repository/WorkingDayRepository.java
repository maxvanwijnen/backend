package com.eindopdracht.eindopdracht.repository;

import com.eindopdracht.eindopdracht.model.WorkOrder;
import com.eindopdracht.eindopdracht.model.WorkingDay;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public interface WorkingDayRepository extends CrudRepository<WorkingDay, Long> {

    WorkingDay findFirstByDate(LocalDate date);
}
