package com.vn.service.impl;

import com.vn.model.Customer;
import com.vn.repository.CustomerRepository;
import com.vn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer create(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer findById(String id) {

		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isPresent()) {
			Customer customer = optional.get();
			return customer;

		} else {
			return null;
		}

	}

	@Override
	public void delete(String id) {
		customerRepository.deleteById(id);

	}

	@Override
	public List<Customer> findAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Integer countElement() {
		return (int) customerRepository.count();
	}

	@Override
	public Page<Customer> findContainElement(String searchParam, Pageable pageable) {
		return customerRepository.findContainElement(searchParam, pageable);

	}

	@Override
	public int countContainElement(String searchParam) {
		return customerRepository.countContainElement(searchParam);
	}

	@Override
	public void deleteCustomer(String id) {
		customerRepository.deleteById(id);

	}

	@Override
	public List<Customer> findElementReport(String fullName, String address, Date dOBFrom, Date dOBTo) {

		return customerRepository.findElementReport(fullName, address, dOBFrom, dOBTo);
	}



}
