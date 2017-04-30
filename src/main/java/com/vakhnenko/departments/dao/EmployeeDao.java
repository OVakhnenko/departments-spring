package com.vakhnenko.departments.dao;

import com.vakhnenko.departments.entity.Department;
import com.vakhnenko.departments.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
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
        Session session = sessionFactory.openSession();

        try {
            if (employee.getEmployee_id() == 0) {
                session.persist(employee);
            } else {
                session.update(employee);
            }
            session.flush();
        } catch (ConstraintViolationException e) {
            logger.error("DEPSPRERR: Dublicate employee entry!", e);
        } finally {
            session.close();
        }

        logger.info("Employee successfully saved. Employee name: " + employee.getName());
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
