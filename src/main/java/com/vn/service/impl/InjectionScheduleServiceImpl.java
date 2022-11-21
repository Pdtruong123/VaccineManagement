package com.vn.service.impl;

import com.vn.dto.InjectionScheduleDTO;
import com.vn.model.InjectionSchedule;
import com.vn.repository.InjectionSchuduleRepository;
import com.vn.repository.VaccineRepository;
import com.vn.service.InjectionScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InjectionScheduleServiceImpl implements InjectionScheduleService {

    @Autowired
    InjectionSchuduleRepository injectionSchuduleRepository;

    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    public InjectionScheduleDTO save(InjectionScheduleDTO injectionScheduleDTO) {
        InjectionSchedule injectionSchedule = new InjectionSchedule();
        injectionSchedule.setVaccine(vaccineRepository.findById(injectionScheduleDTO.getVaccineID()).orElse(null));
        LocalDate startDate = injectionScheduleDTO.getStartDate();
        LocalDate endDate = injectionScheduleDTO.getEndDate();
        if (startDate.isBefore(endDate)) {
            injectionSchedule.setStartDate(startDate);
            injectionSchedule.setEndDate(endDate);
        }
        injectionSchedule.setPlace(injectionScheduleDTO.getPlace());
        injectionSchedule.setDescription(injectionScheduleDTO.getDescription());
        injectionSchuduleRepository.save(injectionSchedule);
        return injectionScheduleDTO;
    }

    @Override
    public InjectionSchedule save1(InjectionSchedule injectionSchedule) {
        injectionSchuduleRepository.save(injectionSchedule);
        return injectionSchedule;
    }

    @Override
    public List<InjectionSchedule> findAll() {
        return injectionSchuduleRepository.findAll();
    }
    public InjectionSchedule findByID(String id){
        return injectionSchuduleRepository.findById(id).orElse(null);
    }
    public InjectionScheduleServiceImpl(InjectionSchuduleRepository injectionSchuduleRepository) {
        this.injectionSchuduleRepository = injectionSchuduleRepository;
    }
}
