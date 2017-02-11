package com.arek.dao;

import com.arek.model.Employee;

import java.util.List;

/**
 * Created by Arek on 09.02.2017.
 */
public interface EmployeeDao {
    List<Employee> getAll();
    void save(Employee employee);
    Employee findById(long id);
    void delete(Employee employee);
    void update(Employee employee);

}
