package com.vn.controller;

import com.vn.config.DTO.InjectionScheduleDTO;
import com.vn.model.InjectionSchedule;
import com.vn.model.Vaccine;
import com.vn.repository.InjectionSchuduleRepository;
import com.vn.repository.VaccineRepository;
import com.vn.service.InjectionScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
@Controller
public class InjectionScheduleController {
    @Autowired
    InjectionSchuduleRepository injectionScheduleReponsitory;

    @Autowired
    VaccineRepository vaccineReponsitory;

    @Autowired
    InjectionScheduleService injectionScheduleService;

    @GetMapping("/injection")
    public String listInjection(Model model) {
        model.addAttribute("injection",new InjectionScheduleDTO());
        List<InjectionSchedule> scheduleList= injectionScheduleReponsitory.findAll();
        model.addAttribute("listInjection", scheduleList);
        List<Vaccine> vaccineList= vaccineReponsitory.findAll();
        model.addAttribute("listVaccine",vaccineList);
        return "create-injection-schedule";
    }

    @PostMapping("/injection")
    public String addInjection(@Valid @ModelAttribute("injection") InjectionScheduleDTO injectionScheduleDTO, BindingResult bindingResult) throws ParseException {
        InjectionSchedule injectionSchedule= new InjectionSchedule();
        injectionSchedule.setStartDate(injectionScheduleDTO.getStartDate());
        injectionSchedule.setEndDate(injectionScheduleDTO.getEndDate());
        injectionSchedule.setPlace(injectionScheduleDTO.getPlace());
        injectionSchedule.setDescription(injectionScheduleDTO.getNote());
        Vaccine vaccine= vaccineReponsitory.findByIdVaccine(injectionScheduleDTO.getVaccineID());
        injectionSchedule.setVaccine(vaccine);
//        injectionScheduleService.save(scheduleDTO);
        injectionScheduleReponsitory.save(injectionSchedule);
        return "listInjection";
    }
}
