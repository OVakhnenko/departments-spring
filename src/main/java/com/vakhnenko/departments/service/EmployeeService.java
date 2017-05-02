package com.vakhnenko.departments.service;

import com.vakhnenko.departments.dao.EmployeeDao;
import com.vakhnenko.departments.entity.Department;
import com.vakhnenko.departments.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Transactional
    public void remove(int id) {
        employeeDao.remove(id);
    }

    @Transactional
    public Employee getEssenceById(int id) {
        return employeeDao.getEssenceById(id);
    }

    @Transactional
    public List<Employee> list() {
        return employeeDao.list();
    }

    @Transactional
    public List<Employee> list(Department department) {
        return employeeDao.list(department);
    }

    @Transactional
    public List<Employee> list(List<Department> departments) {
        if (departments.size() > 0) {
            List<Employee> result = new ArrayList<>();
            for (Department department : departments) {
                List<Employee> employees = employeeDao.list(department);
                for (Employee employee : employees) {
                    employee.setDepartment(department);
                    result.add(employee);
                }
            }
            return result;
        } else {
            return null;
        }
    }
}
