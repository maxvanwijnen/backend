package com.eindopdracht.eindopdracht.service;

import com.eindopdracht.eindopdracht.dto.CustomerDto;
import com.eindopdracht.eindopdracht.dto.WorkingDayDto;
import com.eindopdracht.eindopdracht.exception.ResourceNotFoundException;
import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.model.Invoice;
import com.eindopdracht.eindopdracht.model.WorkingDay;
import com.eindopdracht.eindopdracht.repository.EmployeeRepository;
import com.eindopdracht.eindopdracht.repository.WorkingDayRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkingDayService {
    private final WorkingDayRepository dayRepos;

    public WorkingDayService(WorkingDayRepository dayRepos) {
        this.dayRepos = dayRepos;
    }

    public Long createWorkingDay(WorkingDayDto wdto) {

        //check of de datum al bestaat

        //als de datum bestaat gooi een error

        //als de datum nog niet bestaat maak een nieuwe
        WorkingDay w = new WorkingDay();

        w.setDate(wdto.date);

        dayRepos.save(w);

        return w.getId();
    }

    public WorkingDayDto getWorkingDay(LocalDate date) {
        //Optional<WorkingDay> w = Optional.ofNullable(dayRepos.findFirstByDate(date).orElseThrow(() -> new ResourceNotFoundException("Date not Found")));

        Optional<WorkingDay> optionalDay = dayRepos.findFirstByDate(date);
        WorkingDay w = optionalDay.orElseThrow(() -> new ResourceNotFoundException("WorkingDay not found"));


        WorkingDayDto wdto = new WorkingDayDto();
        wdto.id = w.getId();
        wdto.workOrders = w.getWorkOrders();
        wdto.date = w.getDate();


        /*for (Invoice i : c.getInvoices()){
            cdto.invoices.add(i.getId());
        }*/

        return wdto;
    }

    public List getWorkingDays() {
        Iterable<WorkingDay> workingDays = dayRepos.findAll();

        List<WorkingDayDto> workingDayDtos = new ArrayList<>();
        for (WorkingDay w : workingDays) {
            WorkingDayDto wdto = new WorkingDayDto();
            wdto.id = w.getId();
            wdto.date = w.getDate();
            wdto.workOrders = w.getWorkOrders();

            workingDayDtos.add(wdto);
        }
        return workingDayDtos;
    }
}
