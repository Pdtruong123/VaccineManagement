package com.vn.controller;

import com.vn.config.DTO.InjectionScheduleDTO;
import com.vn.model.InjectionSchedule;
import com.vn.model.Vaccine;
import com.vn.repository.InjectionSchuduleRepository;
import com.vn.repository.VaccineRepository;
import com.vn.service.InjectionScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Controller
public class InjectionScheduleController {
    @Autowired
    InjectionSchuduleRepository injectionScheduleReponsitory;

    @Autowired
    VaccineRepository vaccineReponsitory;

    @Autowired
    InjectionScheduleService injectionScheduleService;

    @GetMapping("/add/injectionSchedule")
    public String listInjection(Model model) {
        model.addAttribute("injection",new InjectionScheduleDTO());
        List<InjectionSchedule> scheduleList= injectionScheduleReponsitory.findAll();
        model.addAttribute("listInjection", scheduleList);
        List<Vaccine> vaccineList= vaccineReponsitory.findAll();
        model.addAttribute("listVaccine",vaccineList);
        return "create-injection-schedule";
    }

    @PostMapping("/add/injectionSchedule")
    public String addInjection(@Valid @ModelAttribute("injection") InjectionScheduleDTO injectionScheduleDTO, BindingResult bindingResult) {
        injectionScheduleService.save(injectionScheduleDTO);
        return "injectionScheduleList";
    }
    @GetMapping("/listInjectionSchedule")
    public String listInjectionSchedule(Model model, @RequestParam("l")Optional<Integer> l){
        org.springframework.data.domain.Pageable pageable= PageRequest.of(l.orElse(0),5);
        Page<InjectionSchedule> page= injectionScheduleReponsitory.findAll(pageable);
        model.addAttribute("listInjectionPage",page);
        return "injectionScheduleList";
    }
}
