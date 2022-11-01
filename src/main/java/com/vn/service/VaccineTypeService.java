package com.vn.service;

import java.util.List;

import com.vn.dto.VaccineTypeDTO;
import com.vn.model.Vaccine;
import com.vn.model.VaccineType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VaccineTypeService {

	String save(VaccineTypeDTO vaccineTypeDTO);

	List<VaccineType> findAll();

	Page<VaccineType> findAll(Pageable pageable);


}
