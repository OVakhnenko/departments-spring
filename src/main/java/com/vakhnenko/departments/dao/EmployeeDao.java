package com.vakhnenko.departments.dao;

import com.vakhnenko.departments.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDao implements Dao<Employee> {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentDao.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Employee employee) {
        Session session = this.sessionFactory.openSession();
        session.persist(employee);
        logger.info("Department successfully saved. Department name: " + employee.getName());
    }
}
