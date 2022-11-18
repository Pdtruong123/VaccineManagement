package com.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.model.UserRole;

@Repository
public interface UserRoleReponsitory extends JpaRepository<UserRole, Integer> {

}
