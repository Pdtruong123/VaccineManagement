package com.vn.service.impl;

import com.vn.model.InjectionResult;
import com.vn.repository.InjectionResultRepository;
import com.vn.service.InjectionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InjectionResultServiceImpl implements InjectionResultService {

    @Autowired
    InjectionResultRepository injectionResultRepository;


    @Override
    public InjectionResult save(InjectionResult injectionResult) {
        return injectionResultRepository.save(injectionResult);
    }

    @Override
    public void deleteInjectionResult(String id) {
        injectionResultRepository.deleteById(id);
    }

    @Override
    public InjectionResult findById(String id) {
        return injectionResultRepository.findById(id).get();
    }

    @Override
    public List<InjectionResult> findElementReport(String prevention, String vaccineType, LocalDate startDate, LocalDate endDate) {
        if(prevention==null){

        }
        return injectionResultRepository.findElementReport(prevention, vaccineType, startDate, endDate);
    }

    @Override
    public List<InjectionResult> findAll() {
        return injectionResultRepository.findAll();
    }


    public InjectionResultServiceImpl(InjectionResultRepository injectionResultRepository) {
        this.injectionResultRepository = injectionResultRepository;
    }
}
