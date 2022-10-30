package com.vn.service.impl;

import com.vn.model.Vaccine;
import com.vn.repository.VaccineRepository;
import com.vn.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Vaccine> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return vaccineRepository.findAll(pageable);
	}


	@Override
	public List<Vaccine> findAll() {
		// TODO Auto-generated method stub
		return vaccineRepository.findAll();
	}


	@Override
	public Page<Vaccine> findByVaccineNameContaining(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return vaccineRepository.findByVaccineNameContaining(name,pageable);
	}
}
