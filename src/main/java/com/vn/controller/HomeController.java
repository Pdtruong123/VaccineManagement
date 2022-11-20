package com.vn.controller;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.vn.model.Customer;
import com.vn.service.InjectionResultService;
import com.vn.service.impl.CustomUserDetail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        ModelAndView model = new ModelAndView("homePage");
        Customer customer = new Customer();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<String> roleName = new ArrayList<>();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            CustomUserDetail userDetails = (CustomUserDetail) auth.getPrincipal();
            customer = userDetails.getCustomer();
            Collection<? extends GrantedAuthority> listRole = userDetails.getAuthorities();
            for (GrantedAuthority r : listRole) {
                roleName.add(r.getAuthority());
            }
            session.setAttribute("emailLogin", customer.getEmail());
        }
        return model;
    }

    @GetMapping(value = {"/login", "/", ""})
    public String viewLogin(Model model, @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("memberLogin", new Customer());
        if (error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }
        return "login";
    }
}

