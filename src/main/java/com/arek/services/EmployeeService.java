package com.arek.services;

import com.arek.model.Employee;

import java.util.List;

/**
 * Created by Arek on 09.02.2017.
 */
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee findEmployeeById(long id);
    void saveEmployee(Employee employee);
    boolean deleteEmployeeById(long id);
    void updateEmployee(Employee employee);
}
