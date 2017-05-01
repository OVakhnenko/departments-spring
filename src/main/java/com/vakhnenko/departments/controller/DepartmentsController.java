package com.vakhnenko.departments.controller;

import com.vakhnenko.departments.entity.Department;
import com.vakhnenko.departments.entity.Employee;
import com.vakhnenko.departments.service.DepartmentService;
import com.vakhnenko.departments.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class DepartmentsController {
    private static final Map<String, String> typeEmployee;

    static {
        typeEmployee = new LinkedHashMap<>();
        typeEmployee.put("M", "Manager");
        typeEmployee.put("D", "Developer");
    }

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;

    @Autowired
    @Qualifier("employeeService")
    private EmployeeService employeeService;

    @RequestMapping(value = "/add/department")
    public String addDepartment(@Valid @ModelAttribute("department") Department department,
                                BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("listDepartments", this.departmentService.list());
            return "departments";
        } else {
            this.departmentService.save(department);
            return "redirect:/departments";
        }
    }

    @RequestMapping(value = "/add/department/{dID}/employee/{eID}")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee,
                              BindingResult result, Model model) {

        boolean hasMethOrLangError = employee.hasMethodologyOrLanguageError();
        if (result.hasErrors() || hasMethOrLangError) {
            model.addAttribute("typeEmployee", typeEmployee);
            model.addAttribute("employee", employee);
            model.addAttribute("department", employee.getDepartment());
            model.addAttribute("listEmployees", this.employeeService.list(employee.getDepartment()));
            if (hasMethOrLangError) {
                model.addAttribute("actionError", "Select type of employee and enter methodology for manager or language for developer!");
            }
            return "employees";
        } else {
            this.employeeService.save(employee);
            return "redirect:/employees";
        }
    }

    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
    public String employees(@PathVariable("id") int id, Model model) {
        Department department = this.departmentService.getEssenceById(id);
        Employee employee = new Employee();
        employee.setDepartment(department);

        model.addAttribute("typeEmployee", typeEmployee);
        model.addAttribute("employee", employee);
        model.addAttribute("department", department);
        model.addAttribute("listEmployees", this.employeeService.list(department));
        return "employees";
    }

    @RequestMapping(value = "/edit/department/{id}", method = RequestMethod.GET)
    public String editDepartment(@PathVariable("id") int id, Model model) {
        model.addAttribute("department", this.departmentService.getEssenceById(id));
        model.addAttribute("listDepartments", this.departmentService.list());
        return "departments";
    }

    @RequestMapping(value = "/remove/department/{id}", method = RequestMethod.GET)
    public String removeDepartment(@PathVariable("id") int id) {
        this.departmentService.remove(id);
        return "redirect:/departments";
    }

    @RequestMapping(value = "/remove/department/{dID}/employee/{eID}", method = RequestMethod.GET)
    public String removeEmployee(@PathVariable("eID") int employee_id, @PathVariable("dID") int department_id, Model model) {
        this.employeeService.remove(employee_id);

        Department department = this.departmentService.getEssenceById(department_id);
        Employee employee = new Employee();
        employee.setDepartment(department);

        model.addAttribute("typeEmployee", typeEmployee);
        model.addAttribute("employee", employee);
        model.addAttribute("department", department);
        model.addAttribute("listEmployees", this.employeeService.list(department));
        return "redirect:/employees";
    }

    @RequestMapping(value = "/delete/all", method = RequestMethod.POST)
    public String deleteAll(ModelMap model) {
        this.departmentService.deleteAll();
        model.addAttribute("department", new Department());
        model.addAttribute("actionMessage", "All data is deleted.");
        return "departments";
    }

    @RequestMapping(value = "/demonstration", method = RequestMethod.POST)
    public String Demonstration(ModelMap model) {
        model.addAttribute("listDepartments", this.departmentService.fillDemoData());
        model.addAttribute("department", new Department());
        model.addAttribute("actionMessage", "Demonstartion data is filled.");
        return "departments";
    }

    @RequestMapping(value = "/cancel/department", method = RequestMethod.POST)
    public String cancelDepartment(ModelMap model) {
        return departments(model);
    }

    @RequestMapping(value = "/departments")
    public String departments1(ModelMap model) {
        return departments(model);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String departments2(ModelMap model) {
        return departments(model);
    }

    private String departments(ModelMap model) {
        model.addAttribute("listDepartments", this.departmentService.list());
        model.addAttribute("department", new Department());
        return "departments";
    }
}