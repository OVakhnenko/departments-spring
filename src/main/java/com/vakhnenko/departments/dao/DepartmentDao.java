package com.vakhnenko.departments.dao;

import com.vakhnenko.departments.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Repository("departmentDao")
public class DepartmentDao implements Dao<Department> {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Department department) {
        Session session = sessionFactory.openSession();

        try {
            session.persist(department);
            session.flush();
        } catch (ConstraintViolationException e) {
            logger.error("DEPSPRERR: Dublicate entry!", e);
        } finally {
            session.close();
        }

        logger.info("Department successfully saved. Department name: " + department.getName());
    }

    public List<Department> list() {
        Session session = this.sessionFactory.openSession();
        List<Department> result = session.createQuery("from Department ").list();

        for (Department department : result) {
            logger.info("Department list: " + department);
        }
        return result;
    }

    public List<Department> fillDemoData() {
        save(new Department("Department Kiev"));
        save(new Department("Department Kharkov"));
        save(new Department("Department Odessa"));

        logger.info("Departments has been filled demonstartion data.");
        return list();
    }
}
