package com.vn.service;

import com.vn.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

public interface CustomerService {
    Customer create(Customer customer);

    Customer findById(String id);

    void delete(String id);

    List<Customer> findAllCustomer();

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    void deleteAllIds(List<String> ids);

    List<Customer> findElementReport(String fullName, String address, Date dOBFrom, Date dOBTo);

    Optional<Customer> CheckFindByUserName(String userName);

    Optional<Customer> CheckFindByEmail(String email);

    Customer update(Customer customer);

    Customer updateWithCurrentPassword(@Valid Customer customer);
}
