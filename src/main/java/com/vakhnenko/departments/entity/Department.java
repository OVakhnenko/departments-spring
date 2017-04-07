package com.vakhnenko.departments.entity;

import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Set;

@Entity
@Table(name = "department", catalog = "departments", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")})
public class Department implements Essence, java.io.Serializable {

    private int department_id;
    @NotEmpty
    private String name;
    private Set<Employee> employees;

    public Department() {

    }

    public Department(String name) {
        this.name = name;
    }

    public void setDepartment_id(int id) {
        this.department_id = department_id;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "department_id", unique = true, nullable = false)
    public int getDepartment_id() {
        return department_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
    public Set<Employee> getEmployees() {
        return employees;
    }
}
