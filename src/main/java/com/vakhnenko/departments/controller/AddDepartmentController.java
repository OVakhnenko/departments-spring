package com.vakhnenko.departments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/departments/add")
public class AddDepartmentController {

    @RequestMapping(method = RequestMethod.GET)
    public String printDepartments(ModelMap model) {
        model.addAttribute("message", "Hello Departments");
        return "departments";
    }
}