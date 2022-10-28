package com.vn.service;

import com.vn.model.Vaccine;

import java.util.List;

public interface VaccineService {
    List<String> findAllVaccineName();
    List<Vaccine> findAll();
}
