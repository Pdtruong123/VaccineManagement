package com.vn.service.impl;

import com.vn.model.Customer;
import com.vn.model.InjectionResult;
import com.vn.repository.InjectionResultRepository;
import com.vn.service.InjectionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InjectionResultServiceImpl implements InjectionResultService {

    @Autowired
    InjectionResultRepository injectionResultRepository;


    @Override
    public InjectionResult save(InjectionResult injectionResult) {
        return injectionResultRepository.save(injectionResult);
    }

    @Override
    public void deleteAllInjectionResult(List<String> ids) {
        injectionResultRepository.deleteAllById(ids);
    }

    @Override
    public void deleteInjectionResult(String id) {
        injectionResultRepository.deleteById(id);
    }


    @Override
    public List<InjectionResult> findByCustomer(Customer customer) {
        return injectionResultRepository.findByCustomer(customer);
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

    @Override
    public InjectionResult findById(String id) {
        Optional<InjectionResult> injectionResult = injectionResultRepository.findById(id);
        if(injectionResult.isPresent()){
            return injectionResult.get();
        } else{
            return null;
        }
    }

    public InjectionResultServiceImpl(InjectionResultRepository injectionResultRepository) {
        this.injectionResultRepository = injectionResultRepository;
    }
}
