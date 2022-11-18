package com.vn.service.impl;

import com.vn.model.Employee;
import com.vn.repository.EmployeeRepository;
import com.vn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.nio.file.Path;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    ServletContext context;


    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee save(Employee employee) {

        if(!employee.getImageFile().isEmpty()) {
            String path = context.getRealPath("/");
            System.out.println("path = " + path);
            try {
                employee.setImageUrl(employee.getImageFile().getOriginalFilename());
                String filePath = path + "/asserts/img/imgemployee/" + employee.getImageUrl();
                employee.getImageFile().transferTo(Path.of(filePath));
                employee.setImageFile(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        employee.setImageFile(employee.getImageFile());
        employee.setImageUrl(employee.getImageUrl());


        return employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findContainElements(String keyword, Pageable pageable) {
        return employeeRepository.findContainElements(keyword, pageable);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> findAll() {return employeeRepository.findAll();

    }
}
