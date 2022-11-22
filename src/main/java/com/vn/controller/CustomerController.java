package com.vn.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.vn.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.vn.model.Customer;
import com.vn.service.CustomerService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	HttpServletRequest httpServletRequest;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/customer/add")
	public ModelAndView showRegistrationForm() {
		ModelAndView model = new ModelAndView("registerCustomer");
		model.addObject("customer", new Customer());
		return model;
	}

	@PostMapping("/customer/add")
	public ModelAndView saveRegister(@Valid @ModelAttribute("customer") Customer customer,
									 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/customer/list");
		ModelAndView modelError = new ModelAndView("registerCustomer");
		Optional<Customer> userName = customerService.CheckFindByUserName(customer.getUserName());
		Optional<Customer> email = customerService.CheckFindByEmail(customer.getEmail());
		if (bindingResult.hasErrors()) {
			return modelError;
		}
		if (userName.isPresent() || email.isPresent()) {
			modelError.addObject("msg", "User Name or Email already existed!");
			return modelError;
		}
		redirectAttributes.addFlashAttribute("msg", "Create successfull!");
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
	public ModelAndView edit(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
		Customer customer = new Customer();
		ModelAndView model = new ModelAndView("updateInjectionCustomerList");
		ModelAndView modelList = new ModelAndView("redirect:/customer/list");
		customer = customerService.findById(id);
		if (customer == null) {
			redirectAttributes.addFlashAttribute("msg", "Customer Id is not exists!");
			return modelList;
		}

		model.addObject("customer", customer);
		return model;
	}

	@PostMapping(value = {"/customer/update"})
	public ModelAndView updateCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result,
									   RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/customer/list");
		ModelAndView modelError = new ModelAndView("updateInjectionCustomerList");
		model.addObject("msg", "Update customer successfull!");
		Optional<Customer> userName = customerService.CheckFindByUserName(customer.getUserName());
		Optional<Customer> email = customerService.CheckFindByEmail(customer.getEmail());
		if (userName.isPresent() && email.isPresent() && customer.getId().equals(userName.get().getId())
				&& customer.getId().equals(email.get().getId())) {

			customerService.update(customer);
			return model;
		}
		if (userName.isPresent() && email.isPresent()) {
			modelError.addObject("msg", "User Name or Email already existed!");
			return modelError;
		}
		if (userName.isPresent()) {
			modelError.addObject("msgUser", "User Name already existed!");
			return modelError;
		}
		if (email.isPresent()) {
			modelError.addObject("msgEmail", "Email already existed!");
			return modelError;
		}
		redirectAttributes.addFlashAttribute("msg", "Update successfull!");
		customerService.update(customer);
		return model;
	}

	@PostMapping("/customer/delete")
	public ModelAndView deleteCustomer(@RequestParam List<String> ids, RedirectAttributes redirectAttributes) {
		customerService.deleteAllIds(ids);
		redirectAttributes.addFlashAttribute("msg", "Delete successfull!");
		ModelAndView model = new ModelAndView("redirect:/customer/list");
		return model;
	}
}
