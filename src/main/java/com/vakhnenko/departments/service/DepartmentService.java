package com.vakhnenko.departments.service;

import com.vakhnenko.departments.dao.DepartmentDao;
import com.vakhnenko.departments.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.save(department);
    }

    public List<Department> list() {
        return departmentDao.list();
    }

    public List<Department> fillDemoData() {
        return departmentDao.fillDemoData();
    }
}
