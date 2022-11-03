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
}
