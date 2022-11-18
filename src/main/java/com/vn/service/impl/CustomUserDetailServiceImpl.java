package com.vn.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.vn.model.Customer;
import com.vn.repository.CustomerRepository;

@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Customer> customerOptional = customerRepository.findByUserName(userName);
		Customer c = new Customer();
		if (customerOptional.isPresent()) {
			c = customerOptional.get();
		}else {
			throw new UsernameNotFoundException("USERNAME NOT FOUND");
		}
		return new CustomUserDetail(c);
	}

}
