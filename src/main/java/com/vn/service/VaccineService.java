package com.vn.service;

import com.vn.dto.VaccineDTO;
import com.vn.model.Vaccine;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VaccineService {
    List<String> findAllVaccineName();
    
    Page<Vaccine> findAll(Pageable pageable);
    
    List<Vaccine> findAll();

	Page<Vaccine> findByVaccineNameContaining(String string, Pageable pageable);

	Boolean hasVaccineById(String id);

	Vaccine save(@Valid VaccineDTO vaccineDTO);

	Vaccine updateInActive(Boolean status, String id);

	Vaccine findVaccineById(String id);

	Vaccine update(@Valid VaccineDTO vaccineDTO);

}
