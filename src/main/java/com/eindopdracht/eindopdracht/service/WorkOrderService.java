package com.eindopdracht.eindopdracht.service;

import com.eindopdracht.eindopdracht.dto.CarDto;
import com.eindopdracht.eindopdracht.dto.WorkOrderDto;
import com.eindopdracht.eindopdracht.dto.WorkingDayDto;
import com.eindopdracht.eindopdracht.exception.ResourceNotFoundException;
import com.eindopdracht.eindopdracht.helper.DtoMapper;
import com.eindopdracht.eindopdracht.model.Car;
import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.model.WorkOrder;
import com.eindopdracht.eindopdracht.model.WorkingDay;
import com.eindopdracht.eindopdracht.repository.CarPartRepository;
import com.eindopdracht.eindopdracht.repository.WorkOrderRepository;
import com.eindopdracht.eindopdracht.repository.WorkingDayRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkOrderService {
    private final WorkOrderRepository workOrderRepos;
    private final WorkingDayRepository wDayRepos;

    public WorkOrderService(WorkOrderRepository workOrderRepos, WorkingDayRepository wDayRepos) {
        this.workOrderRepos = workOrderRepos;
        this.wDayRepos = wDayRepos;
    }

    public WorkOrderDto getWorkOrder(Long id) {
        //Optional<WorkingDay> w = Optional.ofNullable(dayRepos.findFirstByDate(date).orElseThrow(() -> new ResourceNotFoundException("Date not Found")));

        Optional<WorkOrder> optionalWorkOrder = workOrderRepos.findById(id);
        WorkOrder wo = optionalWorkOrder.orElseThrow(() -> new ResourceNotFoundException("Workorder not found"));

        WorkOrderDto wodto = new WorkOrderDto();
        wodto = DtoMapper.mapEntityToDto(wodto, wo);

        /*for (Invoice i : c.getInvoices()){
            cdto.invoices.add(i.getId());
        }*/

        return wodto;
    }

    public List getWorkOrders() {
        Iterable<WorkOrder> workOrders = workOrderRepos.findAll();
        if(!workOrders.iterator().hasNext()){
            throw new ResourceNotFoundException("No workorders found, add a one first");
        }


        List<WorkOrderDto> workOrderDtos = new ArrayList<>();
        for (WorkOrder wo : workOrders) {
            WorkOrderDto wodto = new WorkOrderDto();

            wodto = DtoMapper.mapEntityToDto(wodto, wo);
            /*wdto.id = w.getId();
            wdto.date = w.getDate();
            wdto.workOrders = w.getWorkOrders();*/

            workOrderDtos.add(wodto);
        }
        return workOrderDtos;
    }



    public Long createWorkOrder(WorkOrderDto wdto) {
        WorkOrder w = new WorkOrder();
        //kijk of er al een working datebestaat met deze datum
        //haaldeze op
        Optional<WorkingDay> optionalDay = wDayRepos.findFirstByDate(LocalDate.ofEpochDay(2023-04-12));
        WorkingDay wd = optionalDay.orElseThrow(() -> new ResourceNotFoundException("WorkingDay not found"));


 /*       w.setCar(wdto.car);
        w.setWorkingDay(wDay);
        w.setCompleted(wdto.isCompleted);
*/
        /*workOrderRepos.save(w);*/

        return w.getId();
    }

}
