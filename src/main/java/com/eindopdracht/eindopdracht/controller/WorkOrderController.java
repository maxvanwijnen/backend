package com.eindopdracht.eindopdracht.controller;

import com.eindopdracht.eindopdracht.dto.WorkOrderDto;
import com.eindopdracht.eindopdracht.dto.WorkingDayDto;
import com.eindopdracht.eindopdracht.model.WorkOrder;
import com.eindopdracht.eindopdracht.service.WorkOrderService;
import com.eindopdracht.eindopdracht.service.WorkingDayService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("workorders")
public class WorkOrderController {

    private final WorkOrderService woService;

    public WorkOrderController(WorkOrder woService) {
        this.woService = woService;
    }

    @GetMapping
    ResponseEntity<List<WorkOrder>> getWorkOrders() {
        List<WorkOrderDto> wodtos = woService.getWorkOrders();
        return ResponseEntity.ok(wodtos);
    }

    @GetMapping("/{date}")
    ResponseEntity<Object> getWorkingDay(@PathVariable LocalDate date) {



        //List<WorkingDayDto> wdtos = dayService.getWorkingDay(date);
        WorkingDayDto wdto = dayService.getWorkingDay(date);
        return ResponseEntity.ok(wdto);
    }

    @PostMapping
    public ResponseEntity<Object> createWorkingDay(@Valid @RequestBody WorkingDayDto wdto, BindingResult br) {

        if (br.hasFieldErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage() + "\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        Long id = dayService.createWorkingDay(wdto);
        wdto.id = id;

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + id).toUriString());

        return ResponseEntity.created(uri).body(wdto);
    }


}