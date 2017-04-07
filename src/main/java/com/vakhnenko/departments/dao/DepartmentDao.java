package com.vakhnenko.departments.dao;

import com.vakhnenko.departments.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("departmentDao")
public class DepartmentDao implements Dao {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentDao.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Department department) {
        Session session = this.sessionFactory.openSession();
        session.persist(department);
        logger.info("Department successfully saved. Department name: " + department.getName());
    }
}
