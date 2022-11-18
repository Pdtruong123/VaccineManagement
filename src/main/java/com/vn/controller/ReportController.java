package com.vn.controller;

import com.vn.model.InjectionResult;
import com.vn.model.Vaccine;
import com.vn.service.InjectionResultService;
import com.vn.service.VaccineService;
import com.vn.service.VaccineTypeService;
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
import org.springframework.web.servlet.ModelAndView;

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
    VaccineTypeService vaccineTypeService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    InjectionResultService injectionResultService;



    @GetMapping("report/injection-result")
    public ModelAndView injectionResultReportPage(@RequestParam(value = "p", defaultValue = "0") Integer p,
                                                  @RequestParam(value = "size", defaultValue = "5") Integer size){
        ModelAndView model = new ModelAndView("reportInject");
        Pageable pageable = PageRequest.of(p, size);
        Page<InjectionResult> injectionResults = injectionResultService.findAll(pageable);
        model.addObject("injectionResultList", injectionResults);
        model.addObject("vaccineList", vaccineService.findAll());
        if ((long) size * (injectionResults.getNumber() + 1) > injectionResults.getTotalElements()) {
            model.addObject("firstElement", size * p + 1);
            model.addObject("lastElement", injectionResults.getTotalElements());
        } else {
            model.addObject("firstElement", size * p + 1);
            model.addObject("lastElement", size * (p + 1));
        }
        return model;
    }

    @PostMapping("/search/report/injection-result")
    public ModelAndView searchPage(@RequestParam(value = "p", defaultValue = "0") Integer p,
                             @RequestParam(value = "size", defaultValue = "5") Integer size, @RequestParam("prevention") String prevention,
                             @RequestParam("vaccine") String vaccineType,
                             @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                             @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){

        ModelAndView model = new ModelAndView("reportInject");
        Pageable pageable = PageRequest.of(p, size);


        Page<InjectionResult> injectionResults = injectionResultService.findElementReport(prevention, vaccineType, startDate,endDate,pageable);
        model.addObject("injectionResultList", injectionResults);
        if ((long) size * (injectionResults.getNumber() + 1) > injectionResults.getTotalElements()) {
            model.addObject("firstElement", size * p + 1);
            model.addObject("lastElement", injectionResults.getTotalElements());
        } else {
            model.addObject("firstElement", size * p + 1);
            model.addObject("lastElement", size * (p + 1));
        }
        return model;
    }

    @GetMapping("/chart/injection-result")
    public ModelAndView chartPage(){
        ModelAndView model = new ModelAndView("chartInject");
        return model;
    }

    @GetMapping("report/vaccine")
    public ModelAndView vaccineReportPage(@RequestParam(value = "p", defaultValue = "0") Integer p,
                                                  @RequestParam(value = "size", defaultValue = "5") Integer size){
        ModelAndView model = new ModelAndView("reportVaccine");
        Pageable pageable = PageRequest.of(p, size);
        Page<Vaccine> vaccines = vaccineService.findAll(pageable);
        model.addObject("vaccineList", vaccines);
        model.addObject("vaccineTypeList", vaccineTypeService.findAll());
        if ((long) size * (vaccines.getNumber() + 1) > vaccines.getTotalElements()) {
            model.addObject("firstElement", size * p + 1);
            model.addObject("lastElement", vaccines.getTotalElements());
        } else {
            model.addObject("firstElement", size * p + 1);
            model.addObject("lastElement", size * (p + 1));
        }
        return model;
    }

    @PostMapping("/search/report/vaccine")
    public ModelAndView searchVaccineReportPage(@RequestParam(value = "p", defaultValue = "0") Integer p,
                                   @RequestParam(value = "size", defaultValue = "5") Integer size,
                                   @RequestParam(value ="origin", required = false) String origin,
                                   @RequestParam(value ="vaccineType", required = false) String vaccineType,
                                   @RequestParam(value = "timeBeginNextInjection", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate timeBeginNextInjection,
                                   @RequestParam(value = "timeEndNextInjection", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate timeEndNextInjection){

        ModelAndView model = new ModelAndView("reportVaccine");
        Pageable pageable = PageRequest.of(p, size);

        Page<Vaccine> vaccines = vaccineService.findElementReport(origin, vaccineType, timeBeginNextInjection,timeEndNextInjection,pageable);
        System.out.println(origin);
        System.out.println(vaccineType);
        System.out.println(timeBeginNextInjection);
        System.out.println(timeEndNextInjection);
        System.out.println(pageable);
        model.addObject("vaccineList", vaccines);

        if ((long) size * (vaccines.getNumber() + 1) > vaccines.getTotalElements()) {
            model.addObject("firstElement", size * p + 1);
            model.addObject("lastElement", vaccines.getTotalElements());
        } else {
            model.addObject("firstElement", size * p + 1);
            model.addObject("lastElement", size * (p + 1));
        }
        return model;
    }
}
