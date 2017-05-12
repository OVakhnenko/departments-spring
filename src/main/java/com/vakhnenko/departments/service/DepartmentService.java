package com.vakhnenko.departments.service;

import com.vakhnenko.departments.dao.DepartmentDao;
import com.vakhnenko.departments.entity.Department;
import com.vakhnenko.departments.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Transactional
    public void remove(int id) {
        departmentDao.remove(id);
    }

    @Transactional
    public void deleteAll() {
        departmentDao.deleteAll();
    }

    @Transactional
    public Department getById(int id) {
        return departmentDao.getById(id);
    }

    @Transactional
    public List<Department> list() {
        return departmentDao.list();
    }

    @Transactional
    public Map<Integer, String> map() {
        return departmentDao.map();
    }

    @Transactional
    public List<Department> fillDemoData() {
        return departmentDao.fillDemoData();
    }
}
