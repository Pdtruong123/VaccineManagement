package com.vn.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
    HttpServletRequest httpServletRequest;

    @GetMapping("customer/registerCustomer")
    public ModelAndView showRegistrationForm() {
        ModelAndView model = new ModelAndView("registerCustomer");
        Customer c = new Customer();
        model.addObject("customer", c);
        return model;
    }

    @PostMapping("customer/registerCustomer")
    public ModelAndView saveRegister(@ModelAttribute("customer") Customer customer) {
        ModelAndView model = new ModelAndView("registerCustomer");
        customerService.create(customer);
        model.addObject("customer", customer);
        return model;
    }

    @GetMapping("customer/injectionCustomerList")
    public ModelAndView viewCustomerList(@RequestParam(value = "p", defaultValue = "0") Optional<Integer> p,
                                   @RequestParam(value = "size", defaultValue = "5") Integer size) {
        ModelAndView model = new ModelAndView("injectionCustomerList");
        Pageable pageable = PageRequest.of(p.orElse(0), size);
        Page<Customer> page = customerService.findAll(pageable);
        model.addObject("injectionCustomerList", page);
        Integer total = customerService.countElement();

        if (size >= total) {
            size = total;
        }
        model.addObject("size", size);
        model.addObject("total", total);
        return model;
    }

    @PostMapping("customer/search/injectionCustomerList")
    public ModelAndView searchInjectionCustomerList(@RequestParam(value = "p", defaultValue = "0") Integer p,
                                              @RequestParam(value = "size", defaultValue = "5") Integer size) {
        ModelAndView model = new ModelAndView("injectionCustomerList");
        String keyword = httpServletRequest.getParameter("searchInjectionCustomerList");
        Pageable pageable = PageRequest.of(p, size);
        Page<Customer> page = customerService.findContainElement(keyword, pageable);
        if (page.isEmpty()) {
            model.addObject("error", "No data found!");
        }
        int total = customerService.countContainElement(keyword);
        if (size >= total) {
            size = total;
        }
        model.addObject("size", size);
        model.addObject("injectionCustomerList", page);
        model.addObject("total", total);
        return model;


    }
    @GetMapping(value = { "customer/update/injectionCustomerList/{id}" })
    public ModelAndView edit(@PathVariable("id") String id) {
        ModelAndView model = new ModelAndView("updateInjectionCustomerList");
        Customer customer = customerService.findById(id);
        model.addObject("customer", customer);
        return model;
    }

    @PostMapping(value = { "customer/update/injectionCustomerList" })
    public ModelAndView updateCustomer(BindingResult result, @Valid Customer customer) {
        ModelAndView model = new ModelAndView("redirect:/customer/injectionCustomerList");
        ModelAndView modelError = new ModelAndView("updateInjectionCustomerList");
        if (result.hasErrors()){
            return modelError;
        }else{
            customerService.create(customer);
            return model;
        }
    }

    @PostMapping("customer/delete")
    public String deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/injectionCustomerList";
    }


}
