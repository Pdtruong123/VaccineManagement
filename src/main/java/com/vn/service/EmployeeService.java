package com.vn.service;

import com.vn.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable);
    Employee save(Employee employee);
    Page<Employee> findContainElements(String keyword, Pageable pageable);
    void deleteEmployee(String id);
    Employee findById(String id);

}
