package com.vn.controller;

import com.vn.model.Customer;
import com.vn.model.InjectionResult;
import com.vn.model.Vaccine;
import com.vn.repository.ReportRepository;
import com.vn.service.CustomerService;
import com.vn.service.InjectionResultService;
import com.vn.service.VaccineService;
import com.vn.service.VaccineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/chart/injection-result")
    public ModelAndView chartInjectPage(){
        ModelAndView model = new ModelAndView("chartInject");
        return model;
    }

//    @PostMapping("/chart/injection-result")
//    public ModelAndView chartInjectPageByYear(@RequestParam(value ="year") String year){
//        ModelAndView model = new ModelAndView("chartInject");
//        List<Integer> injectValue = reportRepository.listValueInjectChart(year);
//        injectValue.toString();
//        model.addObject("injectValue", injectValue);
//
//        System.out.println("value = "+injectValue);
//        return model;
//    }

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

    @GetMapping("/chart/vaccine")
    public ModelAndView chartVaccinePage(){
        ModelAndView model = new ModelAndView("chartVaccine");
        //listValueVaccineChart
        return model;
    }


    @GetMapping("report/customer")
    public ModelAndView customerReportPage(@RequestParam(value = "p", defaultValue = "0") Integer p,
                                          @RequestParam(value = "size", defaultValue = "5") Integer size){
        ModelAndView model = new ModelAndView("reportCustomer");
        Pageable pageable = PageRequest.of(p, size);
        Page<Customer> customers = customerService.findAll(pageable);
        model.addObject("customerList", customers);

        if ((long) size * (customers.getNumber() + 1) > customers.getTotalElements()) {
            model.addObject("firstElement", size * p + 1);
            model.addObject("lastElement", customers.getTotalElements());
        } else {
            model.addObject("firstElement", size * p + 1);
            model.addObject("lastElement", size * (p + 1));
        }
        return model;
    }

    @PostMapping("/search/report/customer")
    public ModelAndView searchCustomerReportPage(@RequestParam(value = "p", defaultValue = "0") Integer p,
                                                @RequestParam(value = "size", defaultValue = "5") Integer size,
                                                @RequestParam(value ="fullName", required = false) String fullName,
                                                @RequestParam(value ="address", required = false) String address,
                                                @RequestParam(value = "dOBFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dOBFrom,
                                                @RequestParam(value = "dOBTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dOBTo){

        ModelAndView model = new ModelAndView("reportCustomer");
        Pageable pageable = PageRequest.of(p, size);

        Page<Customer> customers = customerService.findElementReport(fullName, address, dOBFrom,dOBTo,pageable);
        System.out.println(fullName);
        System.out.println(address);
        System.out.println(dOBFrom);
        System.out.println(dOBTo);
        System.out.println(pageable);
        model.addObject("customerList", customers);

        if ((long) size * (customers.getNumber() + 1) > customers.getTotalElements()) {
            model.addObject("firstElement", size * p + 1);
            model.addObject("lastElement", customers.getTotalElements());
        } else {
            model.addObject("firstElement", size * p + 1);
            model.addObject("lastElement", size * (p + 1));
        }
        return model;
    }

    @GetMapping("/chart/customer")
    public ModelAndView chartCustomerPage(){
        ModelAndView model = new ModelAndView("chartCustomer");
        return model;
    }


}
