package com.vakhnenko.departments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class DepartmentsController {

    @RequestMapping(method = RequestMethod.GET)
    public String AddDepartment1(ModelMap model) {
        return AddDepartment(model);
    }

    @RequestMapping(value = "departments", method = RequestMethod.GET)
    public String AddDepartment2(ModelMap model) {
        return AddDepartment(model);
    }

    private String AddDepartment(ModelMap model) {
        model.addAttribute("message", "Departments");
        return "departments";
    }

}