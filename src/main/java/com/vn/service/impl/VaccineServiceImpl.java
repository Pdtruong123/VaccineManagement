package com.vn.service.impl;

import com.vn.dto.VaccineDTO;
import com.vn.model.Vaccine;
import com.vn.repository.VaccineRepository;
import com.vn.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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


	@Override
	public Boolean hasVaccineById(String id) {
		Optional<Vaccine> optionalVaccine = vaccineRepository.findById(id);
		if (optionalVaccine.isPresent()) {
			return true;
		}else {
			return false;
					
		}
	}


	@Override
	public void save(@Valid VaccineDTO vaccineDTO) {
		Vaccine vaccine = new Vaccine();
		vaccine.setId(vaccineDTO.getId());
		vaccine.setStatus(vaccineDTO.getStatus());
		vaccine.setVaccineName(vaccineDTO.getVaccineName());
		vaccine.setVaccineType(vaccineDTO.getVaccineType());
		vaccine.setNumberOfInjection(vaccineDTO.getNumberOfInjection());
		vaccine.setUsage(vaccineDTO.getUsage());
		vaccine.setIndication(vaccineDTO.getIndication());
		vaccine.setContraindication(vaccineDTO.getContraindication());
		vaccine.setTimeBeginNextInjection(vaccineDTO.getTimeBeginNextInjection());
		vaccine.setTimeEndNextInjection(vaccineDTO.getTimeEndNextInjection());
		vaccine.setOrigin(vaccineDTO.getOrigin());
		
		System.out.println(vaccine.getStatus());
		vaccineRepository.save(vaccine);
		
	}
}
