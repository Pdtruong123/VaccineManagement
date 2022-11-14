package com.vn.controller;

import com.vn.service.InjectionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    InjectionResultService injectionResultService;

    @GetMapping(value={"/","","/home", "/index"})
    public ModelAndView homePage(){
        ModelAndView model = new ModelAndView("homePage");
        return model;
    }

    @GetMapping("/listIJ")
    public ModelAndView fakeListPage(){
        ModelAndView model = new ModelAndView("IJList");
        model.addObject("injectionResultList",injectionResultService.findAll());
        return model;
    }
}
