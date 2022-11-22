package com.vn.repository;

import com.vn.model.VaccineType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineTypeRepository extends JpaRepository<VaccineType, String> {

    Page<VaccineType> findByVaccineTypeNameContaining(String name, Pageable pageable);

    @Modifying
    @Query("Update VaccineType vt set vt.vaccineTypeStatus =:status WHERE vt.id IN :ids")
    void upDateStatus(@Param("ids") List<String> ids, @Param("status") boolean inactive);

    @Query("Select vt from VaccineType vt where vt.vaccineTypeStatus =:status")
    List<VaccineType> findByVaccineTypeStatus(Boolean status);

    @Query("Select vt from VaccineType vt where vt.vaccineTypeName =:vaccineTypeName")
    Optional<VaccineType> findByVaccineTypeName(String vaccineTypeName);
}
