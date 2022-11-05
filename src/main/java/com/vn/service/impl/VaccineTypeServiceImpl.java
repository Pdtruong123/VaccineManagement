package com.vn.service.impl;

import java.nio.file.Path;
import java.util.List;

import javax.servlet.ServletContext;

import com.vn.model.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vn.dto.VaccineTypeDTO;
import com.vn.model.VaccineType;
import com.vn.repository.VaccineTypeRepository;
import com.vn.service.VaccineTypeService;

@Service
public class VaccineTypeServiceImpl implements VaccineTypeService  {
	
	@Autowired
    VaccineTypeRepository vaccineTypeRepository;
	
	@Autowired
    ServletContext context;
	
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
		vaccineType.setVaccineTypeStatus(vaccineTypeDTO.getVaccineTypeStatus());
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
		VaccineType vaccineType1 = vaccineTypeRepository.getById(vaccineTypeDTO.getId());

		VaccineType vaccineType = new VaccineType();
		vaccineType.setId(vaccineTypeDTO.getId());
		vaccineType.setVaccineTypeName(vaccineTypeDTO.getVaccineTypeName());
		vaccineType.setVaccineTypeStatus(vaccineTypeDTO.getVaccineTypeStatus());
		vaccineType.setDescription(vaccineTypeDTO.getDescription());
		vaccineType.setImageFile(vaccineTypeDTO.getImageFile());

		if("1".equals(vaccineTypeDTO.getCustomFileInputHidden())){
			vaccineType.setImageUrl(null);
		} else if (vaccineTypeDTO.getImageUrl() == null) {
			vaccineType.setImageUrl(vaccineType1.getImageUrl());
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
	public Page<VaccineType> findAll(Pageable pageable) {

		return vaccineTypeRepository.findAll(pageable);
	}

	@Override
	public Page<VaccineType> findByVaccineTypeNameContaining(String name, Pageable pageable) {
		return vaccineTypeRepository.findByVaccineTypeNameContaining(name,pageable);
	}

	@Override
	public List<VaccineType> findAll() {
		// TODO Auto-generated method stub
		return vaccineTypeRepository.findAll();
	}


}
