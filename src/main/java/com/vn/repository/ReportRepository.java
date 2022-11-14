package com.vn.repository;

import com.vn.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Vaccine, String> {

    @Query(value = "Select ISNULL(c.total,0) from date_report d " +
            "  Left Join " +
            "  (SELECT SUM(ir.number_of_injection) as total, month(injection_date)  as month FROM injection_result ir " +
            "  Where YEAR(injection_date) = ?1 " +
            "  GROUP BY   month(injection_date) ) as c " +
            "  on d.id = c.month", nativeQuery = true)
    List<Integer> listValueInjectChart(String year);

    @Query(value = "Select ISNULL(c.total,0) from date_report d " +
            "  Left Join " +
            "  (SELECT SUM(v.number_of_injection) as total, month(time_begin_next_injection)  as month FROM vaccine v " +
            "  Where YEAR(time_begin_next_injection) = ?1 " +
            "  GROUP BY   month(time_begin_next_injection) ) as c " +
            "  on d.id = c.month", nativeQuery = true)
    List<Integer> listValueVaccineChart(String year);

    @Query(value = "Select ISNULL(c.total,0) from date_report d " +
            "  Left Join " +
            "  (SELECT COUNT(ir.customer_id) as total, month(injection_date)  as month FROM injection_result ir " +
            "  Where YEAR(injection_date) = ?1 " +
            "  GROUP BY   month(injection_date) ) as c " +
            "  on d.id = c.month", nativeQuery = true)
    List<Integer> listValueCustomerChart(String year);


}