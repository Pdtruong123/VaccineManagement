package com.vn.controller;

import com.vn.model.InjectionResult;
import com.vn.service.InjectionResultService;
import com.vn.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class InjectionResultController {

    @Autowired
    InjectionResultService injectionResultService;

    @Autowired
    VaccineService vaccineService;

    @GetMapping("/injection-result-list")
    public String viewPage(Model model, @RequestParam("p")Optional<Integer> p){
        Pageable pageable = PageRequest.of(p.orElse(0),5);
        Page<InjectionResult> page = injectionResultService.findAll(pageable);
        model.addAttribute("injectionResultList", page);
        return "injection-result-list";
    }

    @GetMapping(value={"/add/injection-result", "/update/injection-result"})
    public String addInjectionResultPage(Model model){
        model.addAttribute("preventionList", injectionResultService.findAllPrevention());
        model.addAttribute("vaccineList", vaccineService.findAll());
        model.addAttribute("injectionResult", new InjectionResult());
        return "create-injection-result";
    }

    @PostMapping("/add/injection-result")
    public String addInjectionResult(@Valid @ModelAttribute(value = "injectionResult") InjectionResult injectionResult, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "create-injection-result";
        }
        injectionResultService.save(injectionResult);
        redirectAttributes.addFlashAttribute("success","Successful operation");
        return "redirect:/add/injection-result";
    }

    @PostMapping("/delete/injection-result")
    public String deleteInjectionResult(@RequestParam String id){
        injectionResultService.deleteInjectionResult(id);
        return "redirect:/injection-result-list";
    }
}
