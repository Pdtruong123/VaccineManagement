package com.vn.service;

import java.util.List;

import com.vn.dto.VaccineTypeDTO;
import com.vn.model.Vaccine;
import com.vn.model.VaccineType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VaccineTypeService {

	String save(VaccineTypeDTO vaccineTypeDTO);

	String update(VaccineTypeDTO vaccineTypeDTO);

    VaccineType findById(String id);

    List<VaccineType> findAll();

    void upDateStatus(List<String> ids, Boolean inactive);

    List<VaccineType> findAllActice();

    void upDateStatusVaccine(List<String> ids, Boolean inactive);

    VaccineType findByVaccineTypeName(String vaccineName);
}
