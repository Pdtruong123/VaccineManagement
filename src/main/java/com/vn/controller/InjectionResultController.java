package com.vn.controller;

import com.vn.model.InjectionResult;
import com.vn.service.CustomerService;
import com.vn.service.InjectionResultService;
import com.vn.service.VaccineService;
import com.vn.util.DataInjectionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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



    @GetMapping("/injection-result/list")
    public ModelAndView viewPage() {
        ModelAndView model = new ModelAndView("injectionResultList");
        model.addObject("injectionResultList", injectionResultService.findAll());
        return model;

    }

    @GetMapping("/injection-result/add")
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
        InjectionResult injectionResultUpdate = injectionResultService.findById(id);
        model.addObject("injectionResultUpdate", injectionResultUpdate);
        model.addObject("customer", customerService.findAllCustomer());
        model.addObject("preventionList", DataInjectionResult.preventionData);
        model.addObject("vaccineList", vaccineService.findAll());
        model.addObject("placeOfInjectionList", DataInjectionResult.placeOfInjection);
        return model;
    }

    @PostMapping("/update/injection-result")
    public ModelAndView updateInjectionResult(@Valid @ModelAttribute("injectionResultUpdate") InjectionResult injectionResultUpdate,
                                        BindingResult bindingResult, RedirectAttributes redirectAttributes ){
        ModelAndView modelError = new ModelAndView("update-injection-result");
        ModelAndView model = new ModelAndView("redirect:/injection-result-list");
        if(bindingResult.hasErrors()){
            return modelError;
        }
        injectionResultService.save(injectionResultUpdate);
        redirectAttributes.addFlashAttribute("success", "Successful operation");
        return model;
    }

}
