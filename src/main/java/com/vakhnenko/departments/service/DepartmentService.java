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

    public void save(Department department) {
        departmentDao.save(department);
    }

    public void remove(int id) {
        departmentDao.remove(id);
    }

    public void deleteAll() {
        departmentDao.deleteAll();
    }

    public Department getEssenceById(int id) {
        return departmentDao.getEssenceById(id);
    }

    public List<Department> list() {
        return departmentDao.list();
    }

    public List<Department> fillDemoData() {
        return departmentDao.fillDemoData();
    }
}
