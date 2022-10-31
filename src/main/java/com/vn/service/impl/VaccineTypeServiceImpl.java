package com.vn.service.impl;

import java.nio.file.Path;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<VaccineType> findAll() {
		
		return vaccineTypeRepository.findAll();
	}

}
