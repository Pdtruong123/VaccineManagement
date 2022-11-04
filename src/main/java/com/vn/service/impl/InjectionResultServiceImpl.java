package com.vn.service.impl;

import com.vn.model.InjectionResult;
import com.vn.repository.InjectionResultRepository;
import com.vn.service.InjectionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InjectionResultServiceImpl implements InjectionResultService {

    @Autowired
    InjectionResultRepository injectionResultRepository;


    @Override
    public List<String> findAllPrevention() {
        return injectionResultRepository.findAllPrevention();
    }

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
    public Integer countElement() {
        return (int) injectionResultRepository.count();
    }

    @Override
    public Page<InjectionResult> findContainElement(String searchParam, Pageable pageable) {
        return injectionResultRepository.findContainElement(searchParam, pageable);
    }

    @Override
    public int countContainElement(String searchParam) {
        return injectionResultRepository.countContainElement(searchParam);
    }

    @Override
    public Page<InjectionResult> findAll(Pageable pageable) {
        return injectionResultRepository.findAll(pageable);
    }
}
