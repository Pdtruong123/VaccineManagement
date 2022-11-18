package com.vn.controller;

import com.vn.repository.ReportRepository;
import com.vn.service.CustomerService;
import com.vn.service.InjectionResultService;
import com.vn.service.VaccineService;
import com.vn.service.VaccineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class ReportController {

    @Autowired
    VaccineService vaccineService;

    @Autowired
    VaccineTypeService vaccineTypeService;

    @Autowired
    InjectionResultService injectionResultService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ReportRepository reportRepository;

    @GetMapping("report/injection-result")
    public ModelAndView injectionResultReportPage(){
        ModelAndView model = new ModelAndView("reportInject");
        model.addObject("injectionResultList", injectionResultService.findAll());
        model.addObject("vaccineList", vaccineService.findAll());
        return model;
    }

    @PostMapping("/search/report/injection-result")
    public ModelAndView searchPage(@RequestParam("prevention") String prevention,
                             @RequestParam("vaccine") String vaccineType,
                             @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                             @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){

        ModelAndView model = new ModelAndView("reportInject");

        model.addObject("injectionResultList", injectionResultService.findElementReport(prevention, vaccineType, startDate,endDate));
        model.addObject("vaccineList", vaccineService.findAll());
        return model;
    }

    @GetMapping("/chart/injection-result")
    public ModelAndView chartInjectPage(){
        ModelAndView model = new ModelAndView("chartInject");
        return model;
    }


    @GetMapping("report/vaccine")
    public ModelAndView vaccineReportPage(){
        ModelAndView model = new ModelAndView("reportVaccine");
        model.addObject("vaccineList", vaccineService.findAll());
        model.addObject("vaccineTypeList", vaccineTypeService.findAll());
        return model;
    }

    @PostMapping("/search/report/vaccine")
    public ModelAndView searchVaccineReportPage(@RequestParam(value ="origin", required = false) String origin,
                                   @RequestParam(value ="vaccineType", required = false) String vaccineType,
                                   @RequestParam(value = "timeBeginNextInjection", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate timeBeginNextInjection,
                                   @RequestParam(value = "timeEndNextInjection", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate timeEndNextInjection){

        ModelAndView model = new ModelAndView("reportVaccine");
        model.addObject("vaccineList", vaccineService.findElementReport(origin, vaccineType, timeBeginNextInjection,timeEndNextInjection));
        model.addObject("vaccineTypeList", vaccineTypeService.findAll());
        return model;
    }

    @GetMapping("/chart/vaccine")
    public ModelAndView chartVaccinePage(){
        ModelAndView model = new ModelAndView("chartVaccine");

        return model;
    }

    @GetMapping("report/customer")
    public ModelAndView customerReportPage(){
        ModelAndView model = new ModelAndView("reportCustomer");
        model.addObject("customerList", customerService.findAll());

        return model;
    }

    @PostMapping("/search/report/customer")
    public ModelAndView searchCustomerReportPage(@RequestParam(value ="fullName", required = false) String fullName,
                                                @RequestParam(value ="address", required = false) String address,
                                                @RequestParam(value = "dOBFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dOBFrom,
                                                @RequestParam(value = "dOBTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dOBTo){

        ModelAndView model = new ModelAndView("reportCustomer");
        model.addObject("customerList", customerService.findElementReport(fullName, address, dOBFrom,dOBTo));

        return model;
    }

    @GetMapping("/chart/customer")
    public ModelAndView chartCustomerPage(){
        ModelAndView model = new ModelAndView("chartCustomer");
        return model;
    }

}
