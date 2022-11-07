package com.vn.controller;

import com.vn.model.News;
import com.vn.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class NewsController {

    @Autowired
    NewsService newsService;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/news-list")
    public String newsListPage(Model model, @RequestParam(value = "p",defaultValue = "0") Integer p,
                               @RequestParam(value = "size", defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(p, size);
        Page<News> news = newsService.findAllNews(pageable);
        model.addAttribute("newsList", news);

        if ((long) size * (news.getNumber() + 1) > news.getTotalElements()) {
            model.addAttribute("firstElement", size * p + 1);
            model.addAttribute("lastElement", news.getTotalElements());
        } else {
            model.addAttribute("firstElement", size * p + 1);
            model.addAttribute("lastElement", size * (p + 1));
        }
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
        return "redirect:/add/news";
    }

    @PostMapping("/search/news")
    public String searchNews(Model model, @RequestParam(value = "p",defaultValue = "0") Integer p,
                             @RequestParam(value = "size", defaultValue = "5") Integer size){
        String keyword = request.getParameter("searchNews");
        Pageable pageable = PageRequest.of(p,size);
        Page<News> page = newsService.findContainElements(keyword, pageable);
        if (page.isEmpty()) {
            model.addAttribute("error", "No data found!");
        }
        model.addAttribute("newsList", page);
        return "news-list";
    }

    @PostMapping("/delete/news")
    public String deleteNews(@RequestParam String id){
        newsService.deleteNews(id);
        return "redirect:/news-list";
    }

    @GetMapping("/update/news/{id}")
    public String updateNewsPage(Model model, @PathVariable String id){
        News news = newsService.findById(id);
        model.addAttribute("news", news);
        return "update-news";
    }

    @PostMapping("/update/news")
    public String updateNews(@Valid @ModelAttribute("news") News news, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "update-news";
        }
        news.setPostDate(LocalDate.now());
        newsService.save(news);
        redirectAttributes.addFlashAttribute("success", "Update News Successfully!");
        return "redirect:/news-list";
    }
}
