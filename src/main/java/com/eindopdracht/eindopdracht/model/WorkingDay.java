package com.eindopdracht.eindopdracht.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="workingdays")
public class WorkingDay {
    @Id
    @GeneratedValue
    Long id;

    private LocalDate date;

    @OneToMany(mappedBy = "workingDay")
    private List<WorkOrder> workOrders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<WorkOrder> getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(List<WorkOrder> workOrders) {
        this.workOrders = workOrders;
    }
}
