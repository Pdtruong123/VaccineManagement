package com.vn.api;

import com.vn.dto.InjectionScheduleDTO;
import com.vn.model.InjectionSchedule;
import com.vn.model.Vaccine;
import com.vn.repository.InjectionSchuduleRepository;
import com.vn.repository.VaccineRepository;
import com.vn.service.InjectionScheduleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedule")
public class InjectionScheduleApi {
    @Autowired
    InjectionScheduleService injectionScheduleService;

    @Autowired
    InjectionSchuduleRepository injectionScheduleReponsitory;

    @Autowired
    VaccineRepository vaccineReponsitory;


    @PostMapping("/api/create")
    public InjectionScheduleDTO createInjection(@Valid @RequestBody InjectionScheduleDTO injectionScheduleDTO){
        return injectionScheduleService.save(injectionScheduleDTO);
    }

    @GetMapping("/api/list")
    public List<InjectionScheduleDTO> getListApi(@RequestParam("paging") Optional<Integer> l){
        List<InjectionScheduleDTO> result = new ArrayList<>();
        org.springframework.data.domain.Pageable pageable= PageRequest.of(l.orElse(0),5);

        Page<InjectionSchedule> entities =  injectionScheduleReponsitory.findAll(pageable);
        if(entities != null) {
            entities.forEach(x->{
                InjectionScheduleDTO scheduleDTO= new InjectionScheduleDTO();
                BeanUtils.copyProperties(x, scheduleDTO, "status");

                scheduleDTO.setVaccineID(x.getVaccine().getId());
                scheduleDTO.setVaccineName(x.getVaccine().getVaccineName());
                scheduleDTO.setNote(x.getDescription());
                scheduleDTO.setStatus(x.getStatus());

                result.add(scheduleDTO);
            });
        }
        return result;
    }
//    @GetMapping("/api/search")
//    public List<InjectionScheduleDTO> searchList(@RequestParam ("search")String search){
//        List<InjectionScheduleDTO> result = new ArrayList<>();
//        org.springframework.data.domain.Pageable pageable= PageRequest.of(0,5);
//        Page<InjectionSchedule> entities=injectionScheduleReponsitory.findByName(search,pageable);
//        if(entities != null) {
//            entities.forEach(x->{
//                InjectionScheduleDTO scheduleDTO= new InjectionScheduleDTO();
//                BeanUtils.copyProperties(x, scheduleDTO, "status");
//
//                scheduleDTO.setVaccineID(x.getVaccine().getId());
//                scheduleDTO.setVaccineName(x.getVaccine().getVaccineName());
//                scheduleDTO.setNote(x.getDescription());
//                scheduleDTO.setStatus(x.getStatus());
//
//                result.add(scheduleDTO);
//            });
//        }
//        return result;
//    }
}

