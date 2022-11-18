package com.vn.service.impl;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.vn.model.Vaccine;
import com.vn.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vn.dto.VaccineTypeDTO;
import com.vn.model.VaccineType;
import com.vn.repository.VaccineTypeRepository;
import com.vn.service.VaccineTypeService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VaccineTypeServiceImpl implements VaccineTypeService  {
	
	@Autowired
    VaccineTypeRepository vaccineTypeRepository;

	@Autowired
	VaccineRepository vaccineRepository;
	
	@Autowired
    ServletContext context;

	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Override
	public String save(VaccineTypeDTO vaccineTypeDTO) {
		if(!vaccineTypeDTO.getImageFile().isEmpty()) {
			String path = context.getRealPath("/");
			System.out.println("path = " + path);
			try {
				vaccineTypeDTO.setImageUrl(vaccineTypeDTO.getImageFile().getOriginalFilename());
				String filePath = path + "/asserts/img/imgvaccine/" + vaccineTypeDTO.getImageUrl();
				vaccineTypeDTO.getImageFile().transferTo(Path.of(filePath));
				vaccineTypeDTO.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		VaccineType vaccineType = new VaccineType();
		vaccineType.setId(vaccineTypeDTO.getId());
		vaccineType.setVaccineTypeName(vaccineTypeDTO.getVaccineTypeName());
		vaccineType.setDescription(vaccineTypeDTO.getDescription());
		vaccineType.setImageFile(vaccineTypeDTO.getImageFile());
		vaccineType.setImageUrl(vaccineTypeDTO.getImageUrl());

    	return   vaccineTypeRepository.save(vaccineType).getId();
	}

	@Override
	public String update(VaccineTypeDTO vaccineTypeDTO) {

		if(!vaccineTypeDTO.getImageFile().isEmpty()) {
			String path = context.getRealPath("/");
			System.out.println("path = " + path);
			try {
				vaccineTypeDTO.setImageUrl(vaccineTypeDTO.getImageFile().getOriginalFilename());
				String filePath = path + "/asserts/img/imgvaccine/" + vaccineTypeDTO.getImageUrl();
				vaccineTypeDTO.getImageFile().transferTo(Path.of(filePath));
				vaccineTypeDTO.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		VaccineType vaccineTypeToGetImageCurrent = vaccineTypeRepository.getById(vaccineTypeDTO.getId());

		VaccineType vaccineType = new VaccineType();
		vaccineType.setId(vaccineTypeDTO.getId());
		vaccineType.setVaccineTypeName(vaccineTypeDTO.getVaccineTypeName());

		String status = httpServletRequest.getParameter("vaccineTypeStatus");
        vaccineType.setVaccineTypeStatus("active".equals(status));

		vaccineType.setDescription(vaccineTypeDTO.getDescription());
		vaccineType.setImageFile(vaccineTypeDTO.getImageFile());

		if("1".equals(vaccineTypeDTO.getCustomFileInputHidden())){
			vaccineType.setImageUrl(null);
		} else if (vaccineTypeDTO.getImageUrl() == null) {
			vaccineType.setImageUrl(vaccineTypeToGetImageCurrent.getImageUrl());
		} else {
			vaccineType.setImageUrl(vaccineTypeDTO.getImageUrl());
		}
		return vaccineTypeRepository.save(vaccineType).getId();
	}

	@Override
	public VaccineType findById(String name) {
		return vaccineTypeRepository.getById(name);
	}

	@Override
	public List<VaccineType> findAll() {
		
		return vaccineTypeRepository.findAll();
	}

	@Override
	@Transactional
	public void upDateStatus(List<String> ids, Boolean inactive) {
		vaccineTypeRepository.upDateStatus(ids, inactive);
	}

	@Override
	public List<VaccineType> findAllActice() {
		Boolean status = true;
		return vaccineTypeRepository.findByVaccineTypeStatus(status);
	}

	@Override
	@Transactional
	public void upDateStatusVaccine(List<String> ids, Boolean inactive) {

		vaccineRepository.updateStatusByType(ids, inactive);
	}
}
