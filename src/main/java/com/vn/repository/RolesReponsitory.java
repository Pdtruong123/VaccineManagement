package com.vn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.model.Roles;

@Repository
public interface RolesReponsitory extends JpaRepository<Roles, Integer> {

	Optional<Roles> findByRole(String role);

}
