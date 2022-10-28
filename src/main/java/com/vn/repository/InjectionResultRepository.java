package com.vn.repository;

import com.vn.model.InjectionResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InjectionResultRepository extends JpaRepository<InjectionResult, String> {

    @Query("select distinct i.prevention from InjectionResult i")
    List<String> findAllPrevention();
}
