package com.vn.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vn.model.Customer;

public interface CustomerService {
	Customer create(Customer customer);

	Customer findById(String id);

	void delete(String id);
	
    List<Customer> findAllCustomer();
    
    Page<Customer> findAll(Pageable pageable);

    Integer countElement();
    
    Page<Customer> findContainElement(String searchParam, Pageable pageable);
    
    int countContainElement(String searchParam);
    
    void deleteCustomer(String id);

    Page<Customer> findElementReport(String fullName, String address, Date dOBFrom, Date dOBTo,
                                            Pageable pageable);



}
