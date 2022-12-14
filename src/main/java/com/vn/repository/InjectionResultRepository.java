package com.vn.repository;

import com.vn.model.Customer;
import com.vn.model.InjectionResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InjectionResultRepository extends JpaRepository<InjectionResult, String> {

    @Query("select distinct i.prevention from InjectionResult i")
    List<String> findAllPrevention();

    @Query(value = "select i from InjectionResult i where i.id like %:searchParam% " +
            "or i.prevention like %:searchParam% or i.vaccine.vaccineName like %:searchParam% or i.customer.fullName like %:searchParam%")
    Page<InjectionResult> findContainElement(String searchParam, Pageable pageable);

    @Query("""
            select i from InjectionResult i where (?1 is null OR i.prevention like %?1% )
            AND (?2 = '' OR i.vaccine.id = ?2) 
            AND ((?3 is null OR ?4 is null) OR i.injectionDate between ?3 and ?4)
            """)
    List<InjectionResult> findElementReport(String prevention, String vaccineType, LocalDate startDate, LocalDate endDate);
    List<InjectionResult> findByCustomer(Customer customer);

}
