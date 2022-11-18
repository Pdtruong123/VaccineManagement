package com.vn.service.impl;

import com.vn.model.News;
import com.vn.repository.NewsRepository;
import com.vn.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
   @Autowired
    NewsRepository newsRepository;


    @Override
    public Page<News> findAllNews(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public Page<News> findContainElements(String keyword, Pageable pageable) {
        return newsRepository.findContainElements(keyword, pageable);
    }

    @Override
    public void deleteNews(String id) {
        newsRepository.deleteById(id);
    }

    @Override
    public News findById(String id) {
        return newsRepository.findById(id).get();
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }
}
