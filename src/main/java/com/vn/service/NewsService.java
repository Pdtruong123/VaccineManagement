package com.vn.service;

import com.vn.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {
    Page<News> findAllNews(Pageable pageable);
    News save(News news);
    Page<News> findContainElements(String keyword, Pageable pageable);
    void deleteNews(String id);
    News findById(String id);
    List<News> findAll();
}
