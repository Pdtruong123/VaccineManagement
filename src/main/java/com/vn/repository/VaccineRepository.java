package com.vn.repository;

import com.vn.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, String> {

    @Query("select v.vaccineName from Vaccine v")
    List<String> findAllVaccineName();
}
