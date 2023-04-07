package com.eindopdracht.eindopdracht.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orderlines")
public class Orderline {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @OneToOne
    private CarPart carPart;

    private Integer costs;

    @ManyToOne
    @JoinColumn(name = "workorder_id")
    private WorkOrder workOrder;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CarPart getCarPart() {
        return carPart;
    }

    public void setCarPart(CarPart carPart) {
        this.carPart = carPart;
    }

    public Integer getCosts() {
        return costs;
    }

    public void setCosts(Integer costs) {
        this.costs = costs;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }
}
