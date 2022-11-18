package com.vn.service;

import com.vn.model.InjectionResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface InjectionResultService {
    InjectionResult save(InjectionResult injectionResult);
    void deleteInjectionResult(String id);
    InjectionResult findById(String id);
    List<InjectionResult> findElementReport(String prevention, String vaccineType, LocalDate startDate, LocalDate endDate);
    List<InjectionResult> findAll();

}
