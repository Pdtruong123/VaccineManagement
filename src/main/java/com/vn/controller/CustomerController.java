package com.vn.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.model.Customer;
import com.vn.model.InjectionResult;
import com.vn.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@GetMapping("/registerCustomer")
	public String showRegistrationForm(Model model) {
		model.addAttribute("customer", new Customer());
		
		return "registerCustomer";
	}
	
	@PostMapping("/registerCustomer")
	public String processRegister(@ModelAttribute("customer") Customer customer, Model model) {
		
		customerService.create(customer);
		
		return "registerCustomer"; 
	}
	
	@GetMapping("/injectionCustomerList")
    public String viewCustomerList(Model model, @RequestParam(value = "p", defaultValue = "0") Optional<Integer> p,
                           @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(p.orElse(0), size);
        Page<Customer> page = customerService.findAll(pageable);
        model.addAttribute("injectionCustomerList", page);
        Integer total = customerService.countElement();

        if (size >= total) {
            size = total;
        }
        model.addAttribute("size", size);
        model.addAttribute("total", total);
        return "injectionCustomerList";
    }
	
	@PostMapping("/search/injectionCustomerList")
    public String searchInjectionCustomerList(Model model, @RequestParam(value = "p", defaultValue = "0") Integer p,
                                        @RequestParam(value = "size", defaultValue = "5") Integer size) {
        String keyword = httpServletRequest.getParameter("searchInjectionCustomerList");
        Pageable pageable = PageRequest.of(p, size);
        Page<Customer> page = customerService.findContainElement(keyword, pageable);
        if (page.isEmpty()) {
            model.addAttribute("error", "No data found!");
        }
        int total = customerService.countContainElement(keyword);
        if (size >= total) {
            size = total;
        }
        model.addAttribute("size", size);
        model.addAttribute("injectionCustomerList", page);
        model.addAttribute("total", total);
        return "injectionCustomerList";
   
    
	}
	
	@PostMapping("/delete/customer")
    public String deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return "redirect:/injectionCustomerList";
    }
}
