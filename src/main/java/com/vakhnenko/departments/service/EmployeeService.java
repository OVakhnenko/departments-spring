package com.vakhnenko.departments.service;

import com.vakhnenko.departments.dao.EmployeeDao;
import com.vakhnenko.departments.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
public class EmployeeService implements Servize<Employee> {
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public void add(Employee employee) {
        this.employeeDao.add(employee);
    }
}
