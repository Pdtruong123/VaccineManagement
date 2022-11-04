package com.vn.repository;

import com.vn.model.InjectionResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InjectionResultRepository extends JpaRepository<InjectionResult, String> {

    @Query("select distinct i.prevention from InjectionResult i")
    List<String> findAllPrevention();

    @Query("select i from InjectionResult i where i.id like %:searchParam% or i.prevention like %:searchParam% or i.vaccine.vaccineName like %:searchParam%")
    Page<InjectionResult> findContainElement(String searchParam, Pageable pageable);

    @Query("select count(i) from InjectionResult i where i.id like %:searchParam% or i.prevention like %:searchParam% or i.vaccine.vaccineName like %:searchParam%")
    int countContainElement(String searchParam);
}
