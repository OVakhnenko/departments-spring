package com.vakhnenko.departments.controller;

import com.vakhnenko.departments.entity.department.Department;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class DepartmentsController {

    @RequestMapping(value = "/departments/add", method = RequestMethod.POST)
    public String addDepartment(@Valid @ModelAttribute("department") Department department,
                          BindingResult result, Map<String, Object> model) {

        if (result.hasErrors()) {
            return "departments";
        }
        return "redirect:/departments";
    }

    @RequestMapping(value = "/demonstration", method = RequestMethod.POST)
    public String Demonstration(ModelMap model) {
        List<Department> list = new ArrayList();
        list.add(new Department("Department 1"));
        list.add(new Department("Department 2"));
        list.add(new Department("Department 3"));
        list.add(new Department("Department 4"));
        model.addAttribute("listDepartments", list);
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
        model.addAttribute("department", new Department());
        return "departments";
    }

}