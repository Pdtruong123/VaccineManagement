package com.vn.service;

import com.vn.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface CustomerService {
	Customer create(Customer customer);

	Customer findById(String id);

	void delete(String id);
	
    List<Customer> findAllCustomer();
    
    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    Integer countElement();
    
    Page<Customer> findContainElement(String searchParam, Pageable pageable);
    
    int countContainElement(String searchParam);
    
    void deleteCustomer(String id);

    List<Customer> findElementReport(String fullName, String address, Date dOBFrom, Date dOBTo);



}
