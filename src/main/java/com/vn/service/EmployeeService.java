package com.vn.service;

import com.vn.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployees();
    void save(Employee employee);
    Employee findById(Integer id);

    void deleteEmployee(Integer id);



}
