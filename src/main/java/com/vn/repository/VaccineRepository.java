package com.vn.repository;

import com.vn.model.Vaccine;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, String> {

    @Query("select v.vaccineName from Vaccine v")
    List<String> findAllVaccineName();

    @Query(value = "SELECT v.vaccine_id FROM Vaccine v WHERE v.vaccine_id=:id",nativeQuery = true)
    public Vaccine findByIdVaccine(String id);

}
