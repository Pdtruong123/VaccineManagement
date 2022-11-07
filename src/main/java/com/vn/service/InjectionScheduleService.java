package com.vn.service;

import com.vn.dto.InjectionScheduleDTO;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.ParseException;

public interface InjectionScheduleService {
    InjectionScheduleDTO save(InjectionScheduleDTO injectionScheduleDTO);
}
