package com.vn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	@Query("select c from Customer c where c.id like %:searchParam% or c.fullName like %:searchParam%")
    Page<Customer> findContainElement(String searchParam, Pageable pageable);
	
	@Query("select count(c) from Customer c where c.id like %:searchParam% or c.fullName like %:searchParam%")
    int countContainElement(String searchParam);
}
