package com.vakhnenko.departments.dao;

import com.vakhnenko.departments.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("departmentDao")
public class DepartmentDao implements Dao<Department> {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Department department) {
        Session session = sessionFactory.openSession();
        session.persist(department);
        logger.info("Department successfully saved. Department name: " + department.getName());
    }
}
