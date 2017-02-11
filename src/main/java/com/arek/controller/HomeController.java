package com.arek.controller;

import com.arek.model.Employee;
import com.arek.model.Gender;
import com.arek.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Arek on 08.02.2017.
 */

@RestController
public class HomeController {

    @Autowired
    private EmployeeService service;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listAllEmployees(){
        List<Employee> employees = service.getAllEmployees();
        if(employees.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable long id){
        Employee employee = service.findEmployeeById(id);
        if(employee == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @RequestMapping(value="/employee", method = RequestMethod.POST)
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder uri){
        service.saveEmployee(employee);
        HttpHeaders http = new HttpHeaders();
        http.setLocation(uri.path("/user/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<>(http, HttpStatus.CREATED);
    }

    @RequestMapping(value="/employee/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
        boolean isSucceed = service.deleteEmployeeById(id);
        if(isSucceed)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,
                                                   @RequestBody Employee employee){
        service.updateEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value="/test")
    public ResponseEntity<Employee> test(){
        Employee e = new Employee();
        e.setName("John");
        e.setLastName("Doe");
        e.setGender(Gender.MALE);
        e.setBirthday(LocalDate.of(1993, Month.MARCH, 17));
        e.setHireDate(LocalDate.now());
        service.saveEmployee(e);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }



}
