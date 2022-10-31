package com.vn.repository;

import com.vn.model.Vaccine;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, String> {

    @Query("select v.vaccineName from Vaccine v")
    List<String> findAllVaccineName();

}
