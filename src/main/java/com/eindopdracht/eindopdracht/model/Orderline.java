package com.eindopdracht.eindopdracht.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orderlines")
public class Orderline {
    @Id
    @GeneratedValue
    Long id;

    String description;

    @OneToOne
    CarPart carpart;

    Integer costs;

    @ManyToOne
    @JoinColumn(name = "workorder_id")
    private WorkOrder workOrder;




}
