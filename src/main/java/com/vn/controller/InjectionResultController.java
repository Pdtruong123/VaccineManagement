package com.vn.controller;

import com.vn.model.InjectionResult;
import com.vn.service.CustomerService;
import com.vn.service.InjectionResultService;
import com.vn.service.VaccineService;
import com.vn.util.DataInjectionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class InjectionResultController {

    @Autowired
    InjectionResultService injectionResultService;

    @Autowired
    VaccineService vaccineService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    CustomerService customerService;



    @GetMapping("/injection-result-list")
    public ModelAndView viewPage(@RequestParam(value = "p", defaultValue = "0", required = false) Integer p,
                           @RequestParam(value = "size", defaultValue = "5", required = false) Integer size,
                           @RequestParam(value = "search", required = false) String keyword) {
        ModelAndView model = new ModelAndView("injectionResultList");
       if(keyword==null){
           Pageable pageable = PageRequest.of(p, size);
           Page<InjectionResult> page = injectionResultService.findAll(pageable);
           model.addObject("injectionResultList", page);

           if ((long) size * (page.getNumber() + 1) > page.getTotalElements()) {
               model.addObject("firstElement", size * p + 1);
               model.addObject("lastElement", page.getTotalElements());
           } else {
               model.addObject("firstElement", size * p + 1);
               model.addObject("lastElement", size * (p + 1));
           }
           model.addObject("keyword", keyword);
           return model;
       } else{
           Pageable pageable = PageRequest.of(p, size);
           Page<InjectionResult> page = injectionResultService.findContainElement(keyword, pageable);
           if (page.isEmpty()) {
               model.addObject("error", "No data found!");
           }

           if ((long) size * (page.getNumber() + 1) > page.getTotalElements()) {
               model.addObject("firstElement", size * p + 1);
               model.addObject("lastElement", page.getTotalElements());
           } else {
               model.addObject("firstElement", size * p + 1);
               model.addObject("lastElement", size * (p + 1));
           }
           model.addObject("injectionResultList", page);
           model.addObject("keyword", keyword);
           return model;
       }

    }

    @PostMapping("/search/injection-result")
    public ModelAndView searchInjectionResult(@RequestParam(value = "p", defaultValue = "0") Integer p,
                                        @RequestParam(value = "size", defaultValue = "5") Integer size, RedirectAttributes redirectAttributes) {
        String keyword = request.getParameter("searchInjectionResult");
        ModelAndView model = new ModelAndView("redirect:/injection-result-list?search=" + keyword);
        return model;
    }

    @GetMapping("/add/injection-result")
    public ModelAndView addInjectionResultPage() {
        ModelAndView model = new ModelAndView("createInjectionResult");
        model.addObject("preventionList", DataInjectionResult.preventionData);
        model.addObject("placeOfInjectionList", DataInjectionResult.placeOfInjection);
        model.addObject("vaccineList", vaccineService.findAll());
        model.addObject("injectionResult", new InjectionResult());
        model.addObject("customer", customerService.findAllCustomer());

        return model;
    }

    @PostMapping("/add/injection-result")
    public ModelAndView addInjectionResult(@Valid @ModelAttribute(value = "injectionResult") InjectionResult injectionResult,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView modelError = new ModelAndView("createInjectionResult");
        ModelAndView model = new ModelAndView("redirect:/add/injection-result");
        if (bindingResult.hasErrors()) {
            return modelError;
        }
        injectionResultService.save(injectionResult);
        redirectAttributes.addFlashAttribute("success", "Successful operation");
        return model;
    }

    @PostMapping("/delete/injection-result")
    public String deleteInjectionResult(@RequestParam String id) {
        injectionResultService.deleteInjectionResult(id);
        return "redirect:/injection-result-list";
    }

    @GetMapping("/update/injection-result/{id}")
    public ModelAndView updatePage(@PathVariable String id) {
        ModelAndView model = new ModelAndView("update-injection-result");
        InjectionResult injectionResult = injectionResultService.findById(id);
        model.addObject("injectionResult", injectionResult);
        model.addObject("customer", customerService.findAllCustomer());
        model.addObject("preventionList", DataInjectionResult.preventionData);
        model.addObject("vaccineList", vaccineService.findAll());
        model.addObject("placeOfInjectionList", DataInjectionResult.placeOfInjection);
        return model;
    }

    @PostMapping("/update/injection-result")
    public ModelAndView updateInjectionResult(@Valid @ModelAttribute("injectionResult") InjectionResult injectionResult,
                                        BindingResult bindingResult, RedirectAttributes redirectAttributes ){
        ModelAndView modelError = new ModelAndView("update-injection-result");
        ModelAndView model = new ModelAndView("redirect:/injection-result-list");
        if(bindingResult.hasErrors()){
            return modelError;
        }
        injectionResultService.save(injectionResult);
        redirectAttributes.addFlashAttribute("success", "Successful operation");
        return model;
    }

}
