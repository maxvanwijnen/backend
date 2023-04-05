package com.eindopdracht.eindopdracht.model;

import jakarta.persistence.*;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="invoices")
public class Invoice {
    @Id
    @GeneratedValue
    Long id;


    Integer totalBeforeTax;
    Integer totalAfterTax;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    List<String> orderLines = new ArrayList();

    Integer tax;
    Boolean isPayed;

    public Boolean isPayed() {
        return isPayed;
    }

    public void setPayed(Boolean payed) {
        isPayed = payed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getTotalBeforeTax() {
        return totalBeforeTax;
    }

    public void setTotalBeforeTax(Integer totalBeforeTax) {
        this.totalBeforeTax = totalBeforeTax;
    }

    public Integer getTotalAfterTax() {
        return totalAfterTax;
    }

    public void setTotalAfterTax(Integer totalAfterTax) {
        this.totalAfterTax = totalAfterTax;
    }

    public List<String> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<String> orderLines) {
        this.orderLines = orderLines;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }
}
