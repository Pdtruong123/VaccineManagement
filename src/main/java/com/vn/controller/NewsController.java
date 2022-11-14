package com.vn.controller;

import com.vn.model.News;
import com.vn.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
    public ModelAndView newsListPage(){
        ModelAndView model = new ModelAndView("newsList");
            model.addObject("newsList", newsService.findAll());
            return model;
    }

    @GetMapping("add/news")
    public ModelAndView addNewsPage(){
        ModelAndView model = new ModelAndView("addNews");
        model.addObject("news", new News());
        return model;
    }

    @PostMapping("/add/news")
    public ModelAndView addNews(@Valid @ModelAttribute("news") News news, RedirectAttributes redirectAttributes,
                          BindingResult bindingResult){
        ModelAndView model = new ModelAndView("redirect:/add/news");
        ModelAndView modelError = new ModelAndView("addNews");
        if(bindingResult.hasErrors()){
            return modelError;
        }
        news.setPostDate(LocalDate.now());
        newsService.save(news);
        redirectAttributes.addFlashAttribute("success","Add news successfully!");
        return model;
    }

    @PostMapping("/delete/news")
    public ModelAndView deleteNews(@RequestParam String id){
        newsService.deleteNews(id);
        ModelAndView model = new ModelAndView("redirect:/news-list");
        return model;
    }

    @GetMapping("/update/news/{id}")
    public ModelAndView updateNewsPage(@PathVariable String id){
        ModelAndView model = new ModelAndView("update-news");
        News news = newsService.findById(id);
        model.addObject("news", news);
        return model;
    }

    @PostMapping("/update/news")
    public ModelAndView updateNews(@Valid @ModelAttribute("news") News news, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        ModelAndView modelError = new ModelAndView("update-news");
        ModelAndView model = new ModelAndView("redirect:/news-list");
        if(bindingResult.hasErrors()){
            return modelError;
        }
        news.setPostDate(LocalDate.now());
        newsService.save(news);
        redirectAttributes.addFlashAttribute("success", "Update News Successfully!");
        return model;
    }
}
