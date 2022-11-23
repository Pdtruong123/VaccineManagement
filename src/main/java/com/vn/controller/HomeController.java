package com.vn.controller;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.vn.model.Customer;
import com.vn.service.InjectionResultService;
import com.vn.service.impl.CustomUserDetail;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	InjectionResultService injectionResultService;

	@GetMapping(value = {"/home", "/index"})
	public ModelAndView homePage(HttpSession session) {
		ModelAndView modelHome = new ModelAndView("homePage");
		Customer customer = new Customer();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			CustomUserDetail userDetails = (CustomUserDetail) auth.getPrincipal();
			customer = userDetails.getCustomer();
			session.setAttribute("roleNames", userDetails.getAuthorities());
			session.setAttribute("memberLogin", customer);

		}
		session.setAttribute("emailLogin", customer.getEmail());

		return modelHome;
	}

	@GetMapping(value = {"/login", "/", ""})
	public ModelAndView viewLogin(@RequestParam(value = "error", required = false) String error, HttpSession session) {
		ModelAndView modelHome = new ModelAndView("homePage");
		if (session.getAttribute("memberLogin") != null) {
			return modelHome;
		}
		ModelAndView modelLogin = new ModelAndView("login");
		modelLogin.addObject("memberLogin", new Customer());
		if (error != null) {
			modelLogin.addObject("error", "Invalid user name or password!");
		}
		return modelLogin;
	}
}
