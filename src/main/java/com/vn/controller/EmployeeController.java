package com.vn.controller;

import com.vn.model.Employee;
import com.vn.model.News;
import com.vn.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.activation.MimeType;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;


@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/employee/list")
    public ModelAndView employeeListPage(){
        ModelAndView model = new ModelAndView("employeeList");
        model.addObject("employeeList", employeeService.findAll());
        return model;
    }

    @GetMapping("/employee/add")
    public ModelAndView addEmployeePage(){
        ModelAndView model = new ModelAndView("employeeAdd");
        model.addObject("employee", new Employee());
        return model;
    }

    @PostMapping("/employee/add")
    public ModelAndView addEmployee(@Valid @ModelAttribute("employee") Employee employee
                              , RedirectAttributes redirectAttributes
                              ,BindingResult bindingResult){
        ModelAndView modelError = new ModelAndView("employeeAdd");
        ModelAndView model = new ModelAndView("redirect:/employee/add");
        if(bindingResult.hasErrors()){
            return modelError;
        }

        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success","Add employee successfully!");
        return model;
    }

    @PostMapping("/employee/delete")
    public ModelAndView deleteEmployee(@RequestParam String id){
        ModelAndView model = new ModelAndView("redirect:/employee/list");
        employeeService.deleteEmployee(id);
        return model;
    }

    @GetMapping("/employee/update/{id}")
    public ModelAndView updateEmployeePage(@PathVariable String id){
        ModelAndView model = new ModelAndView("update-employee");
        Employee employee = employeeService.findById(id);
        model.addObject("employee", employee);
        return model;
    }

    @PostMapping("/employee/update")
    public ModelAndView updateEmployee(@Valid @ModelAttribute("employee") Employee employee
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes){
        ModelAndView modelError = new ModelAndView("update-employee");
        ModelAndView model = new ModelAndView("redirect:/employee/list");
        if(bindingResult.hasErrors()){
            return modelError;
        }


        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Update Employee Successfully!");
        return model;
    }

}
