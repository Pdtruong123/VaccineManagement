package com.vn.service;

import com.vn.model.InjectionResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InjectionResultService {
    Page<InjectionResult> findAll(Pageable pageable);
    List<String> findAllPrevention();
    InjectionResult save(InjectionResult injectionResult);
    void deleteInjectionResult(String id);
    InjectionResult findById(String id);
}
