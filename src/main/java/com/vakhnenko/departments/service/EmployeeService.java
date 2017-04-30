package com.vakhnenko.departments.service;

import com.vakhnenko.departments.dao.EmployeeDao;
import com.vakhnenko.departments.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> list() {
        return employeeDao.list();
    }
}
