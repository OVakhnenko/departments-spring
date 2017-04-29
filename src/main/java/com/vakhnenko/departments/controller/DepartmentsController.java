package com.vakhnenko.departments.controller;

import com.vakhnenko.departments.entity.Department;
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

@Controller
@RequestMapping("/")
public class DepartmentsController {

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;

    @Autowired
    @Qualifier("employeeService")
    private EmployeeService employeeService;

    @RequestMapping(value = "/department/add", method = RequestMethod.POST)
    public String addDepartment(@Valid @ModelAttribute("department") Department department,
                                BindingResult result) {

        if (result.hasErrors()) {
            return "departments";
        } else {
            this.departmentService.save(department);
            return "redirect:/departments";
        }
    }

    @RequestMapping(value = "/department/edit/{id}", method = RequestMethod.GET)
    public String editDepartment(@PathVariable("id") int id, Model model) {
        model.addAttribute("department", this.departmentService.getEssenceById(id));
        model.addAttribute("listDepartments", this.departmentService.list());
        return "departments";
    }

    @RequestMapping(value = "/department/remove/{id}", method = RequestMethod.GET)
    public String removeDepartment(@PathVariable("id") int id) {
        this.departmentService.remove(id);
        return "redirect:/departments";
    }

    @RequestMapping(value = "/delete/all", method = RequestMethod.POST)
    public String deleteAll(ModelMap model) {
        this.departmentService.deleteAll();
        model.addAttribute("actionMessage", "All data is deleted.");
        model.addAttribute("department", new Department());
        return "departments";
    }

    @RequestMapping(value = "/demonstration", method = RequestMethod.POST)
    public String Demonstration(ModelMap model) {
        model.addAttribute("actionMessage", "Demonstartion data is filled.");
        model.addAttribute("listDepartments", this.departmentService.fillDemoData());
        model.addAttribute("department", new Department());
        return "departments";
    }

    @RequestMapping(value = "/department/cancel", method = RequestMethod.POST)
    public String cancelDepartment1(ModelMap model) {
        return AddDepartment(model);
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