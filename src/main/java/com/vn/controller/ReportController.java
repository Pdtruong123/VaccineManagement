package com.vn.controller;

import com.vn.model.InjectionResult;
import com.vn.service.InjectionResultService;
import com.vn.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class ReportController {

    @Autowired
    HttpSession session;

    @Autowired
    VaccineService vaccineService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    InjectionResultService injectionResultService;



    @GetMapping("report/injection-result")
    public String injectionResultReportPage(Model model, @RequestParam(value = "p", defaultValue = "0") Integer p,
                                            @RequestParam(value = "size", defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(p, size);
        Page<InjectionResult> injectionResults = injectionResultService.findAll(pageable);
        model.addAttribute("injectionResultList", injectionResults);
        model.addAttribute("vaccineList", vaccineService.findAll());
        if ((long) size * (injectionResults.getNumber() + 1) > injectionResults.getTotalElements()) {
            model.addAttribute("firstElement", size * p + 1);
            model.addAttribute("lastElement", injectionResults.getTotalElements());
        } else {
            model.addAttribute("firstElement", size * p + 1);
            model.addAttribute("lastElement", size * (p + 1));
        }
        return "report-inject-result";
    }

    @PostMapping("/search/report/injection-result")
    public String searchPage(Model model, @RequestParam(value = "p", defaultValue = "0") Integer p,
                             @RequestParam(value = "size", defaultValue = "5") Integer size, @RequestParam("prevention") String prevention,
                             @RequestParam("vaccine") String vaccineType,
                             @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                             @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){

        Pageable pageable = PageRequest.of(p, size);


        Page<InjectionResult> injectionResults = injectionResultService.findElementReport(prevention, vaccineType, startDate,endDate,pageable);
        model.addAttribute("injectionResultList", injectionResults);
        if ((long) size * (injectionResults.getNumber() + 1) > injectionResults.getTotalElements()) {
            model.addAttribute("firstElement", size * p + 1);
            model.addAttribute("lastElement", injectionResults.getTotalElements());
        } else {
            model.addAttribute("firstElement", size * p + 1);
            model.addAttribute("lastElement", size * (p + 1));
        }
        return "report-inject-result";
    }

    @GetMapping("/chart/injection-result")
    public String chartPage(){
        return "chart-inject-result";
    }
}
