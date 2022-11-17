package com.vn.controller;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.vn.model.Customer;
import com.vn.service.InjectionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    InjectionResultService injectionResultService;

    @GetMapping(value={"/home", "/index"})
    public ModelAndView homePage(){
        ModelAndView model = new ModelAndView("homePage");
        return model;
    }
    
    @GetMapping(value = {"/login","/",""})
    public String viewLogin(Model model,@RequestParam(value = "error",required = false) String error) {
    	model.addAttribute("memberLogin", new Customer());
    	if (error != null) {
            model.addAttribute("error","Invalid username and password!");
        }
    	return "login";
    }
}
