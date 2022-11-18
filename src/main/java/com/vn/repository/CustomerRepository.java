package com.vn.repository;

import com.vn.model.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.model.Customer;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("select c from Customer c where c.id like %:searchParam% or c.fullName like %:searchParam%")
    Page<Customer> findContainElement(String searchParam, Pageable pageable);

    @Query("select count(c) from Customer c where c.id like %:searchParam% or c.fullName like %:searchParam%")
    int countContainElement(String searchParam);

    @Query("""
                select c from Customer c  where (?1 is null OR c.fullName like %?1% ) AND (?2 is null OR c.address like %?2%)
                 AND ((?3 is null OR ?4 is null) OR c.dateOfBirth between ?3 and ?4)  
                 """)
    List<Customer> findElementReport(String fullName, String address, Date dOBFrom, Date dOBTo);

	Optional<Customer> findByUserName(String userName);


}
