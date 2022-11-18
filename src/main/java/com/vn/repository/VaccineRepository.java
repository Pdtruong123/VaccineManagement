package com.vn.repository;

import com.vn.model.InjectionResult;
import com.vn.model.Vaccine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, String> {

    @Query("select v.vaccineName from Vaccine v")
    List<String> findAllVaccineName();

	Page<Vaccine> findByVaccineNameContaining(String name, Pageable pageable);
	
	@Modifying
    @Query("Update Vaccine v set v.status =:status WHERE v.id IN :ids")
    void updateStatus(@Param("ids") List<String> ids, @Param("status") boolean status);

    @Query("""
            select v from Vaccine v where (?1 is null OR v.origin like %?1% ) AND (?2 = '' OR v.vaccineType.id = ?2)
             AND ((?3 is null OR ?4 is null) OR v.timeBeginNextInjection between ?3 and ?4)  
             AND ((?3 is null OR ?4 is null) OR v.timeEndNextInjection between ?3 and ?4)
             """)
    List<Vaccine> findElementReport(String origin, String vaccineType, LocalDate timeBeginNextInjection, LocalDate timeEndNextInjection);

    @Modifying
    @Query("Update Vaccine v set v.status =:status WHERE v.vaccineType.id IN :ids")
    void updateStatusByType(@Param("ids") List<String> ids, @Param("status") boolean status);
}
