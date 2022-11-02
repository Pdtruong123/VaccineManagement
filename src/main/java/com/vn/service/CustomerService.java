package com.vn.service;

import java.util.List;

import com.vn.model.Customer;

public interface CustomerService {
	
	Customer create(Customer customer);

	Customer findById(Integer id);

	Customer save(Customer customer);

	boolean delete(Integer id);

	List<Customer> findAll();
	

}
