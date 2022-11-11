package com.vn.controller;

import com.vn.dto.InjectionScheduleDTO;
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
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView listInjection(Model model) {
        model.addAttribute("injection",new InjectionScheduleDTO());
        List<InjectionSchedule> scheduleList= injectionScheduleReponsitory.findAll();
        model.addAttribute("listInjection", scheduleList);
        List<Vaccine> vaccineList= vaccineReponsitory.findAll();
        model.addAttribute("listVaccine",vaccineList);
        ModelAndView modelAndView= new ModelAndView("createSchedule");
        return modelAndView;
    }
    @GetMapping("/lisst")
    public ModelAndView getlist(){
        ModelAndView modelAndView= new ModelAndView("ListSchedule");
        return modelAndView;
    }
    @PostMapping("/add/injectionSchedule")
    public ModelAndView addInjection(@Valid @ModelAttribute("injection") InjectionScheduleDTO injectionScheduleDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            ModelAndView modelerror= new ModelAndView("errorcreate");
            return modelerror;
        }
        injectionScheduleService.save(injectionScheduleDTO);
        ModelAndView modelAndView= new ModelAndView("redirect:/lisst");
        return modelAndView;
    }
}
