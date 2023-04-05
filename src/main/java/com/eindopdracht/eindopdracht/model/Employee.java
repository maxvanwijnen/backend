package com.eindopdracht.eindopdracht.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Boolean available;

/*
    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "customer")
    private List<Car> cars;
*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
