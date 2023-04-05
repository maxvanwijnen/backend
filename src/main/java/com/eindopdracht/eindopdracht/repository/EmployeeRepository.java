package com.eindopdracht.eindopdracht.repository;

import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
