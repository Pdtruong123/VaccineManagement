package com.vn.repository;

import com.vn.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("select n from Employee n where n.employeeName like %:keyword%")
    Page<Employee> findContainElements(String keyword, Pageable pageable);

    @Modifying
    @Query("Delete from  Employee e  WHERE e.id IN :ids")
    void deleteByIds(@Param("ids") List<String> ids);
}
