package com.vn.service;

import com.vn.dto.InjectionScheduleDTO;
import com.vn.model.InjectionSchedule;

import java.util.List;

public interface InjectionScheduleService {
    InjectionScheduleDTO save(InjectionScheduleDTO injectionScheduleDTO);

    InjectionSchedule save1(InjectionSchedule injectionSchedule);

    List<InjectionSchedule> findAll();

    InjectionSchedule findByID(String id);
}
