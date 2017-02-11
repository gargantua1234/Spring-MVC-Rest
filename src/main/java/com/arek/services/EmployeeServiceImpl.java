package com.arek.services;

import com.arek.dao.EmployeeDao;
import com.arek.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Arek on 09.02.2017.
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }

    @Override
    public Employee findEmployeeById(long id) {
        return employeeDao.findById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public boolean deleteEmployeeById(long id){
        Employee employee = employeeDao.findById(id);
        if(employee != null){
            employeeDao.delete(employee);
            return true;
        }
        return false;
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }


}
