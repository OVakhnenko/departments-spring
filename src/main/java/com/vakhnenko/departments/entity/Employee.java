package com.vakhnenko.departments.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "employee", catalog = "departments", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Employee implements Essence, java.io.Serializable {

    private int employee_id;
    @Min(18)
    @Max(99)
    private int age;
    @NotEmpty
    private String name;
    @NotEmpty
    private String type;
    private String language;
    private String methodology;
    private Department department;


    public Employee() {
    }

    public Employee(String name, String type, int age, String language, String methodology, Department department) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.language = language;
        this.methodology = methodology;
        this.department = department;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "employee_id", unique = true, nullable = false)
    public int getEmployee_id() {
        return employee_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "age", nullable = false, precision = 3, scale = 0)
    public int getAge() {
        return age;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(name = "language", nullable = false)
    public String getLanguage() {
        return language;
    }

    public void setMethodology(String methodology) {
        this.methodology = methodology;
    }

    @Column(name = "methodology", nullable = false)
    public String getMethodology() {
        return methodology;
    }

    public boolean hasMethodologyOrLanguageError() {
        boolean developer = type.equals("D");
        boolean hasMethodology = !methodology.equals("");
        boolean manager = type.equals("M");
        boolean hasLanguage = !language.equals("");

        if ((!developer && !manager) ||
                (developer && hasMethodology) ||
                (manager && hasLanguage) ||
                (developer && !hasLanguage) ||
                (manager && !hasMethodology)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Employee { name=" + name + " id=" + employee_id + '}';
    }
}
