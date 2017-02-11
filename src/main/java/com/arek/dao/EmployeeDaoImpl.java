package com.arek.dao;

import com.arek.model.Employee;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Arek on 09.02.2017.
 */
@Repository
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

    @Override
    public List<Employee> getAll() {
        Query query = getSession().createQuery("from Employee");
        return (List<Employee>) query.list();
    }

    @Override
    public void save(Employee employee) {
        persist(employee);
    }

    @Override
    public Employee findById(long id) {
        return getSession().get(Employee.class, id);
    }

    @Override
    public void delete(Employee employee) {
        delete(employee);
    }

    @Override
    public void update(Employee employee) {
        getSession().update(employee);
    }
}
