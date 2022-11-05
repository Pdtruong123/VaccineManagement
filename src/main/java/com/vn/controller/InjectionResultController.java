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


    @GetMapping("/injection-result-list")
    public String viewPage(Model model, @RequestParam(value = "p", defaultValue = "0") Integer p,
                           @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(p, size);
        Page<InjectionResult> page = injectionResultService.findAll(pageable);
        model.addAttribute("injectionResultList", page);

        if ((long) size * (page.getNumber() + 1) > page.getTotalElements()) {
            model.addAttribute("firstElement", size * p + 1);
            model.addAttribute("lastElement", page.getTotalElements());
        } else {
            model.addAttribute("firstElement", size * p + 1);
            model.addAttribute("lastElement", size * (p + 1));
        }
        return "injection-result-list";
    }

    @PostMapping("/search/injection-result")
    public String searchInjectionResult(Model model, @RequestParam(value = "p", defaultValue = "0") Integer p,
                                        @RequestParam(value = "size", defaultValue = "5") Integer size) {
        String keyword = request.getParameter("searchInjectionResult");
        Pageable pageable = PageRequest.of(p, size);
        Page<InjectionResult> page = injectionResultService.findContainElement(keyword, pageable);
        if (page.isEmpty()) {
            model.addAttribute("error", "No data found!");
        }

        if ((long) size * (page.getNumber() + 1) > page.getTotalElements()) {
            model.addAttribute("firstElement", size * p + 1);
            model.addAttribute("lastElement", page.getTotalElements());
        } else {
            model.addAttribute("firstElement", size * p + 1);
            model.addAttribute("lastElement", size * (p + 1));
        }
        model.addAttribute("injectionResultList", page);

        return "injection-result-list";
    }

    @GetMapping("/add/injection-result")
    public String addInjectionResultPage(Model model) {
        model.addAttribute("preventionList", DataInjectionResult.preventionData);
        model.addAttribute("placeOfInjectionList", DataInjectionResult.placeOfInjection);
        model.addAttribute("vaccineList", vaccineService.findAll());
        model.addAttribute("injectionResult", new InjectionResult());
        model.addAttribute("customer", customerService.findAllCustomer());

        return "create-injection-result";
    }

    @PostMapping("/add/injection-result")
    public String addInjectionResult(@Valid @ModelAttribute(value = "injectionResult") InjectionResult injectionResult,
                                     BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create-injection-result";
        }
        injectionResultService.save(injectionResult);
        redirectAttributes.addFlashAttribute("success", "Successful operation");
        return "redirect:/add/injection-result";
    }

    @PostMapping("/delete/injection-result")
    public String deleteInjectionResult(@RequestParam String id) {
        injectionResultService.deleteInjectionResult(id);
        return "redirect:/injection-result-list";
    }

    @GetMapping("/update/injection-result/{id}")
    public String updatePage(Model model, @PathVariable String id) {
        InjectionResult injectionResult = injectionResultService.findById(id);
        model.addAttribute("injectionResult", injectionResult);
        model.addAttribute("customer", customerService.findAllCustomer());
        model.addAttribute("preventionList", DataInjectionResult.preventionData);
        model.addAttribute("vaccineList", vaccineService.findAll());
        model.addAttribute("placeOfInjectionList", DataInjectionResult.placeOfInjection);
        return "update-injection-result";
    }

    @PostMapping("/update/injection-result")
    public String updateInjectionResult(Model model,
                                        @Valid @ModelAttribute("injectionResult") InjectionResult injectionResult,
                                        BindingResult bindingResult, RedirectAttributes redirectAttributes ){
        if(bindingResult.hasErrors()){
            return "update-injection-result";
        }
        injectionResultService.save(injectionResult);
        redirectAttributes.addFlashAttribute("success", "Successful operation");
        return "redirect:/injection-result-list";
    }

}
