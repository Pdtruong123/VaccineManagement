package com.vn.repository;

import com.vn.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select n from Employee n where n.id like %:keyword% or n.content like %:keyword% or n.title like %:keyword%")
    Page<Employee> findContainElements(String keyword, Pageable pageable);
}
