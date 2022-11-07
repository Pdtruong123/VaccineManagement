package com.vn.service.impl;

import com.vn.model.Employee;
import com.vn.repository.EmployeeRepository;
import com.vn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);

    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).get();
    }



    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
