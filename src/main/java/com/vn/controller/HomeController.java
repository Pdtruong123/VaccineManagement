package com.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(value={"/","","/home", "/index"})
    public ModelAndView homePage(){
        ModelAndView model = new ModelAndView("homePage");
        return model;
    }
}
