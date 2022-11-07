package com.vn.repository;

import com.vn.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, String> {

    @Query("select n from News n where n.id like %:keyword% or n.content like %:keyword% or n.title like %:keyword%")
    Page<News> findContainElements(String keyword, Pageable pageable);
}
