package com.vn.service.impl;

import com.vn.model.Employee;
import com.vn.model.VaccineType;
import com.vn.repository.EmployeeRepository;
import com.vn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Employee update(Employee employee) {

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
        
        Employee employeeCurrent = employeeRepository.getById(employee.getId());
        employee.setImageFile(employee.getImageFile());
        
        if("1".equals(employee.getCustomFileInputHidden())){
        	employee.setImageUrl(null);
		} else if (employee.getImageUrl() == null) {
			employee.setImageUrl(employeeCurrent.getImageUrl());
		} else {
			employee.setImageUrl(employee.getImageUrl());
		}


        return employeeRepository.save(employee);
    }


    @Override
    public Page<Employee> findContainElements(String keyword, Pageable pageable) {
        return employeeRepository.findContainElements(keyword, pageable);
    }

    @Override
    @Transactional
    public void deleteEmployee(List<String> ids) {
        employeeRepository.deleteAllById(ids);
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> findAll() {return employeeRepository.findAll();

    }
}
