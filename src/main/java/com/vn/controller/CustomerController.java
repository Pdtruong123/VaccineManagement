package com.vn.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.vn.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.vn.model.Customer;
import com.vn.service.CustomerService;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/customer/add")
    public ModelAndView showRegistrationForm() {
        ModelAndView model = new ModelAndView("registerCustomer");
        Customer c = new Customer();
        model.addObject("customer", c);
        return model;
    }

    @PostMapping("/customer/add")
    public ModelAndView saveRegister(@ModelAttribute("customer") Customer customer) {
        ModelAndView model = new ModelAndView("redirect:/customer/list");
        ModelAndView modelError = new ModelAndView("registerCustomer");
        Optional<Customer> userName = customerRepository.CheckFindByUserName(customer.getUserName());
        Optional<Customer> email = customerRepository.CheckFindByEmail(customer.getEmail());
        if (userName.isPresent() && email.isPresent()) {
            model.addObject("msg", "Email or User Name Duplicate");
            return modelError;
        }
        if (userName.isPresent()) {
            model.addObject("msg", "Email or User Name Duplicate");
            return modelError;
        }
        if (email.isPresent()) {
            model.addObject("msg", "Email or User Name Duplicate");
            return modelError;
        }
        customerService.create(customer);
        return model;
    }

    @GetMapping("/customer/list")
    public ModelAndView viewCustomerList() {
        ModelAndView model = new ModelAndView("injectionCustomerList");
        List<Customer> list = customerService.findAll();
        model.addObject("injectionCustomerList", list);

        return model;
    }


    @GetMapping(value = {"/customer/update/{id}"})
    public ModelAndView edit(@PathVariable("id") String id) {
        ModelAndView model = new ModelAndView("updateInjectionCustomerList");
        Customer customer = customerService.findById(id);
        model.addObject("customer", customer);
        return model;
    }

    @PostMapping(value = {"/customer/update"})
    public ModelAndView updateCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {
        ModelAndView model = new ModelAndView("redirect:/customer/list");
        ModelAndView modelError = new ModelAndView("updateInjectionCustomerList");
        model.addObject("msg", "Update customer successfull!");
//        final String userNameDefault= customer.getUserName();
//        final String emailDefault= customer.getEmail();
        Optional<Customer> userName = customerRepository.CheckFindByUserName(customer.getUserName());
        Optional<Customer> email = customerRepository.CheckFindByEmail(customer.getEmail());
        if (userName.isPresent() && email.isPresent() && customer.getId().equals(userName.get().getId())
                && customer.getId().equals(email.get().getId())) {
            customerService.update(customer);
            return model;
        }
        if (userName.isPresent() && email.isPresent()) {
            model.addObject("msg", "Email or User Name Duplicate");
            return modelError;
        }
        if (userName.isPresent()) {
            model.addObject("msg", "Email or User Name Duplicate");
            return modelError;
        }
        if (email.isPresent()) {
            model.addObject("msg", "Email or User Name Duplicate");
            return modelError;
        } else {
            customerService.update(customer);
            return model;
        }
    }

    @PostMapping("/customer/delete")
    public ModelAndView deleteCustomer(@RequestParam List<String> ids) {
        customerService.deleteAllIds(ids);
        ModelAndView model = new ModelAndView("redirect:/customer/list");
        return model;
    }
}
