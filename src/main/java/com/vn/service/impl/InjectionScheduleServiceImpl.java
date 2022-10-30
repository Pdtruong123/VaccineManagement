package com.vn.service.impl;

import com.vn.config.DTO.InjectionScheduleDTO;
import com.vn.model.InjectionSchedule;
import com.vn.model.Vaccine;
import com.vn.repository.InjectionSchuduleRepository;
import com.vn.repository.VaccineRepository;
import com.vn.service.InjectionScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class InjectionScheduleServiceImpl implements InjectionScheduleService {

    @Autowired
    InjectionSchuduleRepository injectionSchuduleRepository;

    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    public InjectionScheduleDTO save(InjectionScheduleDTO injectionScheduleDTO){
////        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
//
//        Date startDate =  injectionScheduleDTO.getStartDate();
//
//        Date endDate = injectionScheduleDTO.getEndDate();
//        InjectionSchedule injectionSchedule = new InjectionSchedule();
////        if (endDate.compareTo(startDate) > 0) {
//            injectionSchedule.setStartDate(startDate);
//            injectionSchedule.setEndDate(endDate);
//            injectionSchedule.setDescription(injectionScheduleDTO.getNote());
//            injectionSchedule.setPlace(injectionScheduleDTO.getPlace());
//            injectionSchedule.setId("abc1");
//            Vaccine vaccine = vaccineRepository.findByIDVaccine(injectionScheduleDTO.getVaccineID());
//            injectionSchedule.setVaccine(vaccine);
//            injectionSchuduleRepository.save(injectionSchedule);
////        }
        return injectionScheduleDTO;
    }
}
