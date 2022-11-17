package com.vn.repository;

import com.vn.model.InjectionSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InjectionSchuduleRepository extends JpaRepository<InjectionSchedule, String> {
}
