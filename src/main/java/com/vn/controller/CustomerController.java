package com.vn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vn.model.Customer;
import com.vn.repository.CustomerRepository;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@GetMapping("/registerCustomer")
	public String showRegistrationForm(Model model) {
		model.addAttribute("customer", new Customer());
		
		return "registerCustomer";
	}
	
	@PostMapping("/registerCustomer")
	public String processRegister(@ModelAttribute("customer") Customer customer, Model model) {
//		customer.setDateOfBirth(LocalDate.of(0, 0, 0));
		String password = httpServletRequest.getParameter("password");
		String rePassword = httpServletRequest.getParameter("rePassword");
		if (password.equals(rePassword)) {
			customerRepository.save(customer);
			model.addAttribute("messSave", "Successful Registration");
			return "registerCustomer";
		}
		return "registerCustomer"; 
	}

   
    
    
}
