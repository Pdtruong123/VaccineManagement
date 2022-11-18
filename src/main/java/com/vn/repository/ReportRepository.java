package com.vn.repository;

import com.vn.model.InjectionResult;
import com.vn.model.News;
import com.vn.model.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReportRepository extends JpaRepository<News, String> {

    @Query("select i from InjectionResult i where i.prevention like %:prevention% or i.vaccine.vaccineName =:vaccineType" +
            " or i.injectionDate between :startDate and :endDate")
    Page<InjectionResult> findInjectionResultReport(String prevention, String vaccineType, LocalDate startDate, LocalDate endDate,
                                            Pageable pageable);

    @Query("select v from Vaccine v where v.origin like %:origin% AND v.vaccineType.id =:vaccineType" +
            " or (v.timeBeginNextInjection between :timeBeginNextInjection and :timeEndNextInjection)  " +
            " or (v.timeEndNextInjection between :timeBeginNextInjection and :timeEndNextInjection)")
    Page<Vaccine> findVaccineReport(String origin, String vaccineType, LocalDate timeBeginNextInjection, LocalDate timeEndNextInjection,
                                    Pageable pageable);

}