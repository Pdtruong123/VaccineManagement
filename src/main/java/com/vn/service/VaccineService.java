package com.vn.service;

import com.vn.model.Vaccine;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VaccineService {
    List<String> findAllVaccineName();
    
    Page<Vaccine> findAll(Pageable pageable);
    
    List<Vaccine> findAll();

	Page<Vaccine> findByVaccineNameContaining(String string, Pageable pageable);
}
