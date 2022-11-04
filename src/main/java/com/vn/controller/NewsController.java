package com.vn.controller;

import com.vn.model.News;
import com.vn.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("/news-list")
    public String newsListPage(Model model, @RequestParam(value = "p",defaultValue = "0") Integer p,
                               @RequestParam(value = "size", defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(p, size);
        model.addAttribute("newsList", newsService.findAllNews(pageable));
        return "news-list";
    }

    @GetMapping("add/news")
    public String addNewsPage(Model model){
        model.addAttribute("news", new News());
        return "create-news";
    }

    @PostMapping("/add/news")
    public String addNews(@Valid @ModelAttribute("news") News news, RedirectAttributes redirectAttributes,
                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "create-news";
        }
        news.setPostDate(LocalDate.now());
        newsService.save(news);
        redirectAttributes.addFlashAttribute("success","Add news successfully!");
        return "/add/news";
    }
}