package com.vn.api;

import com.vn.dto.InjectionScheduleDTO;
import com.vn.model.InjectionSchedule;
import com.vn.model.Vaccine;
import com.vn.repository.InjectionSchuduleRepository;
import com.vn.repository.VaccineRepository;
import com.vn.service.InjectionScheduleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class InjectionScheduleApi {
    @Autowired
    InjectionScheduleService injectionScheduleService;

    @Autowired
    InjectionSchuduleRepository injectionScheduleReponsitory;

    @Autowired
    VaccineRepository vaccineReponsitory;


    @PostMapping("/add/injection")
    public InjectionScheduleDTO createInjection(InjectionScheduleDTO injectionScheduleDTO){
        return injectionScheduleService.save(injectionScheduleDTO);
    }

    @GetMapping("/list")
    public List<InjectionSchedule> getList(){
        return injectionScheduleReponsitory.findAll();
    }
    @GetMapping("/lisvaccine")
    public List<Vaccine> getList1(){
        return vaccineReponsitory.findAll();
    }
    @GetMapping("/api/list")
    public List<InjectionScheduleDTO> getListApi(){
        List<InjectionScheduleDTO> result = new ArrayList<>();

        List<InjectionSchedule> entities = injectionScheduleReponsitory.findAll();
        if(entities != null) {
            entities.forEach(x->{
                InjectionScheduleDTO scheduleDTO= new InjectionScheduleDTO();
                BeanUtils.copyProperties(x, scheduleDTO);
                scheduleDTO.setVaccineID(x.getVaccine().getId());
                scheduleDTO.setVaccineName(x.getVaccine().getVaccineName());
                scheduleDTO.setNote(x.getDescription());
                result.add(scheduleDTO);
            });
        }
        return result;
    }
}

