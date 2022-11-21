package com.vn.controller;

import com.vn.dto.InjectionScheduleDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class InjectionScheduleController {
    @Autowired
    InjectionSchuduleRepository injectionScheduleReponsitory;

    @Autowired
    VaccineRepository vaccineReponsitory;

    @Autowired
    InjectionScheduleService injectionScheduleService;

    @GetMapping("/injectionSchedule/add")
    public ModelAndView listInjection(Model model) {
        model.addAttribute("injection", new InjectionScheduleDTO());
        List<InjectionSchedule> scheduleList = injectionScheduleService.findAll();
        model.addAttribute("listInjection", scheduleList);
        List<Vaccine> vaccineList = vaccineReponsitory.findAll();
        model.addAttribute("listVaccine", vaccineList);
        ModelAndView modelAndView = new ModelAndView("createSchedule");
        return modelAndView;
    }

    @GetMapping("/injection-schedule/list")
    public ModelAndView getlist() {
        ModelAndView modelAndView = new ModelAndView("ListSchedule");
        modelAndView.addObject("listSchedule", injectionScheduleService.findAll());
        return modelAndView;
    }

    @PostMapping("/injectionSchedule/add")
    public ModelAndView addInjection(@Valid @ModelAttribute("injection") InjectionScheduleDTO injectionScheduleDTO, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("redirect:/injection-schedule/list");
        ModelAndView modelerror = new ModelAndView("createSchedule");
        if (bindingResult.hasErrors()) {
            return modelerror;
        }
        injectionScheduleService.save(injectionScheduleDTO);
        modelAndView.addObject("successAdd","Successfully");
        return modelAndView;
    }

    @GetMapping("/injectionSchedule/update")
    public ModelAndView getUpdate(@RequestParam String id, Model model) {
        InjectionSchedule injectionSchedule = injectionScheduleService.findByID(id);
        model.addAttribute("updateSchedule", injectionSchedule);
        ModelAndView modelAndView = new ModelAndView("update");
        return modelAndView;
    }

    @PostMapping("/injectionSchedule/update")
    public ModelAndView postUpdate(@ModelAttribute("updateSchedule") InjectionSchedule injectionSchedule) {
        injectionScheduleService.save1(injectionSchedule);
        ModelAndView modelAndView = new ModelAndView("redirect:/lisst");
        return modelAndView;
    }
}
