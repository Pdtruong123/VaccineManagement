package com.vn.service.impl;

import com.vn.model.Customer;
import com.vn.model.Roles;
import com.vn.model.UserRole;
import com.vn.repository.CustomerRepository;
import com.vn.repository.RolesReponsitory;
import com.vn.repository.UserRoleReponsitory;
import com.vn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	RolesReponsitory rolesReponsitory;
	
	@Autowired
	UserRoleReponsitory userRoleReponsitory;

	@Override
	public Customer create(Customer customer) {
		Optional<Roles> roleOptional = rolesReponsitory.findByRole("USER");
        Roles role = new Roles();
        if (roleOptional.isPresent()) {
            role = roleOptional.get();
        } else {
            role.setRole("USER");
            role = rolesReponsitory.save(role);
        }

        Customer customerSave = new Customer();
        customerSave.setAddress(customer.getAddress());
        customerSave.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerSave.setDateOfBirth(customer.getDateOfBirth());
        customerSave.setEmail(customer.getEmail());
        customerSave.setFullName(customer.getFullName());
        customerSave.setGender(customer.getGender());
        customerSave.setIdentityCard(customer.getIdentityCard());
        customerSave.setPhone(customer.getPhone());
        customerSave.setUserName(customer.getUserName());
        
        
        customerRepository.save(customerSave);
        
		
		UserRole userRole = new UserRole();
		userRole.setCustomer(customerSave);
		userRole.setRole(role);
		
		userRoleReponsitory.save(userRole);
		
		
		
		System.out.println(customerSave);
		
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
	public void deleteAllIds(List<String> ids) {
		customerRepository.deleteAllById(ids);
	}

	@Override
	public List<Customer> findElementReport(String fullName, String address, Date dOBFrom, Date dOBTo) {

		return customerRepository.findElementReport(fullName, address, dOBFrom, dOBTo);
	}



}
