package com.vn.repository;

import com.vn.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Vaccine, String> {

    @Query(value = "Select ISNULL(c.total,0) from DateInject d " +
            "  Left Join " +
            "  (SELECT COUNT(ir.number_of_injection) as total, month(injection_date)  as month FROM injection_result ir " +
            "  Where YEAR(injection_date) = ?1 " +
            "  GROUP BY   month(injection_date) ) as c " +
            "  on d.id = c.month", nativeQuery = true)
    List<Integer> listValueInjectChart(String year);



}