package com.vakhnenko.departments.controller;

import com.vakhnenko.departments.entity.Department;
import com.vakhnenko.departments.service.DepartmentService;
import com.vakhnenko.departments.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class DepartmentsController {

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/department/remove/{id}")
    public String removeBook(@PathVariable("id") int id) {
        this.departmentService.remove(id);
        return "redirect:/departments";
    }

    @RequestMapping(value = "/department/add", method = RequestMethod.POST)
    public String addDepartment(@Valid @ModelAttribute("department") Department department,
                          BindingResult result, Map<String, Object> model) {

        if (result.hasErrors()) {
            return "departments";
        } else {
            this.departmentService.add(department);
            return "redirect:/departments";
        }
    }

    @RequestMapping(value = "/demonstration", method = RequestMethod.POST)
    public String Demonstration(ModelMap model) {
        model.addAttribute("listDepartments", this.departmentService.fillDemoData());
        model.addAttribute("department", new Department());
        return "departments";
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String AddDepartment1(ModelMap model) {
        return AddDepartment(model);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String AddDepartment2(ModelMap model) {
        return AddDepartment(model);
    }

    private String AddDepartment(ModelMap model) {
        model.addAttribute("listDepartments", this.departmentService.list());
        model.addAttribute("department", new Department());
        return "departments";
    }
}