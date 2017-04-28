package com.vakhnenko.departments.dao;

import com.vakhnenko.departments.entity.Department;
import com.vakhnenko.departments.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDao implements Dao<Employee> {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Employee employee) {
        Session session = this.sessionFactory.openSession();

        session.persist(employee);
        session.flush();
        session.close();

        logger.info("Department successfully saved. Department name: " + employee.getName());
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public Employee getEssenceById(int id) {
        return null;
    }

    public List<Employee> list() {
        Session session = this.sessionFactory.openSession();
        List<Employee> result = session.createQuery("from Employee ").list();

        for (Employee employee : result) {
            logger.info("Employee list: " + employee);
        }
        return result;
    }

    @Override
    public List<Employee> fillDemoData() {
        return null;
    }
}
