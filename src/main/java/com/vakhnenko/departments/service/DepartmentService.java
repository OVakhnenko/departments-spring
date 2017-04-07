package com.vakhnenko.departments.service;

import com.vakhnenko.departments.dao.DepartmentDao;
import com.vakhnenko.departments.entity.Department;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("departmentService")
public class DepartmentService implements Servize {
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    @Transactional
    public void addDepartment(Department department) {
        this.departmentDao.add(department);
    }
}
