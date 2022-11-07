package com.vn.service.impl;

import com.vn.dto.VaccineDTO;
import com.vn.model.Vaccine;
import com.vn.repository.VaccineRepository;
import com.vn.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Vaccine save(@Valid VaccineDTO vaccineDTO) {
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
		
		if (vaccine.getTimeBeginNextInjection().isAfter(vaccine.getTimeEndNextInjection())) {
			return null;
		}else {
			vaccineRepository.save(vaccine);
			return vaccine;
		}
		
		
		
	}


	@Override
	public Vaccine updateInActive(Boolean status, String id) {
		
		Optional<Vaccine> optionalV = vaccineRepository.findById(id);
		if (optionalV.isPresent()) {
			Vaccine vaccine = optionalV.get();
			vaccine.setStatus(status);
			vaccineRepository.save(vaccine);
			return vaccine;
		}else {
			return null;
		}
		
		
	}


	@Override
	public Vaccine findVaccineById(String id) {
		Optional<Vaccine> vaccineOptional = vaccineRepository.findById(id);
		if (vaccineOptional.isEmpty()) {
			return null;
		}else {
			Vaccine vaccine = vaccineOptional.get();
			return vaccine;
		}
		
		
	}


	@Override
	public Vaccine update(@Valid VaccineDTO vaccineDTO) {
		if (vaccineDTO.getTimeBeginNextInjection().isAfter(vaccineDTO.getTimeEndNextInjection())) {
			return null;
		}
		Optional<Vaccine> vaccineOptional = vaccineRepository.findById(vaccineDTO.getId());
		if (vaccineOptional.isEmpty()) {
			return null;
		}else {
			Vaccine vaccine = vaccineOptional.get();
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
			vaccineRepository.save(vaccine);
			return vaccine;
		}	
	}
	
	@Override
	@Transactional
	public void updateStatus(List<String> ids, Boolean status) {
		vaccineRepository.updateStatus(ids, status);
	}
}
