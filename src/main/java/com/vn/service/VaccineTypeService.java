package com.vn.service;

import java.util.List;

import com.vn.dto.VaccineTypeDTO;
import com.vn.model.VaccineType;

public interface VaccineTypeService {

	String save(VaccineTypeDTO vaccineTypeDTO);
	
	List<VaccineType> findAll();

}
