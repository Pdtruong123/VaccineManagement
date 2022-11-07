package com.vn.controller;

import com.vn.model.Employee;
import com.vn.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class EmployeeController {
    @Autowired
     EmployeeService employeeService;

    // display list of employees
    @GetMapping("/employee/list")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees",employeeService.getAllEmployees());

        return "employee-list";

    }

    //save employees

    @GetMapping("/add/employee")
    public String addEmployeePage( Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create-employee";
    }

    @PostMapping("/add/employee")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee,
                              RedirectAttributes redirectAttributes,
                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "create-employee";
        }

        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success","Add employee successfully!");
        return "redirect:/add/employee";

    }

    //delete employees

    @PostMapping("/delete/employee")
    public String deleteEmployee(@RequestParam Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/employee-list";
    }

    //update employees

    @GetMapping("/update/employee/{id}")
    public String updateEmployeePage(@PathVariable(value = "id") Integer id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @PostMapping("/update/employee")
    public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "update_employee";
        }

        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Update Employee Successfully!");
        return "redirect:/employee-list";
    }

}
