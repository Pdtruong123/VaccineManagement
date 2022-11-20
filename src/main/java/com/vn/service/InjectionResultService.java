package com.vn.service;

import com.vn.model.Customer;
import com.vn.model.InjectionResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface InjectionResultService {
    InjectionResult save(InjectionResult injectionResult);
    void deleteAllInjectionResult(List<String> id);
    void deleteInjectionResult(String id);
    List<InjectionResult> findByCustomer(Customer customer);
    List<InjectionResult> findElementReport(String prevention, String vaccineType, LocalDate startDate, LocalDate endDate);
    List<InjectionResult> findAll();
    InjectionResult findById(String id);
}
