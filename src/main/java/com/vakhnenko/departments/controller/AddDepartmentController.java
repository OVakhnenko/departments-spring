package com.vakhnenko.departments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department/add")
public class AddDepartmentController {

    @RequestMapping(method = RequestMethod.GET)
    public String Departments(ModelMap model) {
        model.addAttribute("message", "Add Department");
        return "departments";
    }
}