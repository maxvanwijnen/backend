package com.eindopdracht.eindopdracht.service;

import com.eindopdracht.eindopdracht.dto.CarDto;
import com.eindopdracht.eindopdracht.dto.WorkOrderDto;
import com.eindopdracht.eindopdracht.model.Car;
import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.model.WorkOrder;
import com.eindopdracht.eindopdracht.model.WorkingDay;
import com.eindopdracht.eindopdracht.repository.CarPartRepository;
import com.eindopdracht.eindopdracht.repository.WorkOrderRepository;
import com.eindopdracht.eindopdracht.repository.WorkingDayRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkOrderService {
    private final WorkOrderRepository workOrderRepos;
    private final WorkingDayRepository wDayRepos;

    public WorkOrderService(WorkOrderRepository workOrderRepos, WorkingDayRepository wDayRepos) {
        this.workOrderRepos = workOrderRepos;
        this.wDayRepos = wDayRepos;
    }

    public Long createWorkOrder(WorkOrderDto wdto) {
        WorkOrder w = new WorkOrder();
        //kijk of er al een working datebestaat met deze datum
        //haaldeze op
        WorkingDay wDay = wDayRepos.findFirstByDate(wdto.workingDay.getDate());

        w.setCar(wdto.car);
        w.setWorkingDay(wDay);
        w.setCompleted(wdto.isCompleted);

        workOrderRepos.save(w);

        return w.getId();
    }

}
