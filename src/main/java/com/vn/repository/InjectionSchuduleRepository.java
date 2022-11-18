package com.vn.repository;

import com.vn.controller.InjectionScheduleController;
import com.vn.model.InjectionSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InjectionSchuduleRepository extends JpaRepository<InjectionSchedule, String> {
	@Query(value = "SELECT c FROM InjectionSchedule c WHERE c.place LIKE %:search%")
	Page<InjectionSchedule> findByName(String search, Pageable pageable);

	@Modifying
	@Query(value = "Delete from InjectionSchedule where vaccine.id in :ids")
	void deleteByListVaccine(@Param("ids") List<String> ids);
}
