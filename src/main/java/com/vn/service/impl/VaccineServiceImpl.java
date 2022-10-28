package com.vn.service.impl;

import com.vn.model.Vaccine;
import com.vn.repository.VaccineRepository;
import com.vn.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {
    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    public List<String> findAllVaccineName() {
        return vaccineRepository.findAllVaccineName();
    }

    @Override
    public List<Vaccine> findAll() {
        return vaccineRepository.findAll();
    }
}
