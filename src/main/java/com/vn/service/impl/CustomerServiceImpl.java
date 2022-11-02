package com.vn.service.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.model.Customer;
import com.vn.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private SessionFactory factory;
	
	@Override
	public Customer create(Customer customer) {
		Session session = factory.getCurrentSession();
		session.save(customer);
		return customer;
	}

	@Override
	public Customer findById(Integer id) {
		Session session = factory.getCurrentSession();
		Customer m = session.get(Customer.class, id);
		return m;
	}

	@Override
	public Customer save(Customer customer) {
		Session session = factory.getCurrentSession();
		session.update(customer);
		return customer;
	}

	@Override
	public boolean delete(Integer id) {
		Session session = factory.getCurrentSession();
		Customer customer = session.load(Customer.class, id);
		session.delete(customer);
		return true;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = null;
		Session session = factory.getCurrentSession();
		TypedQuery<Customer>  q = session.createQuery("SELECT c FROM Customer c",Customer.class );
		customers = q.getResultList();
		return customers;
	}

	

}
