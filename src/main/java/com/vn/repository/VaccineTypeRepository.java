package com.vn.repository;

import com.vn.model.Vaccine;
import com.vn.model.VaccineType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccineTypeRepository extends JpaRepository<VaccineType, String> {

    @Query("select v.vaccineTypeName from VaccineType v")
    List<String> findAllVaccineTypeName();

}
