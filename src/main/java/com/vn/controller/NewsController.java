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
import java.util.List;

@Controller
public class NewsController {

    @Autowired
    NewsService newsService;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/news/list")
    public ModelAndView newsListPage(){
        ModelAndView model = new ModelAndView("newsList");
            model.addObject("newsList", newsService.findAll());
            return model;
    }

    @GetMapping("/news/add")
    public ModelAndView addNewsPage(){
        ModelAndView model = new ModelAndView("addNews");
        model.addObject("news", new News());
        return model;
    }

    @PostMapping("/news/add")
    public ModelAndView addNews(@Valid @ModelAttribute("news") News news, RedirectAttributes redirectAttributes,
                          BindingResult bindingResult){
        ModelAndView model = new ModelAndView("redirect:/news/list");
        ModelAndView modelError = new ModelAndView("addNews");
        if(bindingResult.hasErrors()){
            return modelError;
        }
        news.setPostDate(LocalDate.now());
        news.setContent(request.getParameter("content"));
        newsService.save(news);
        redirectAttributes.addFlashAttribute("success","Add news successfully!");
        return model;
    }

    @PostMapping("/news/delete")
    public ModelAndView deleteNews(@RequestParam List<String> ids){
        newsService.deleteAllNews(ids);
        ModelAndView model = new ModelAndView("redirect:/news/list");
        return model;
    }

    @GetMapping("/news/update/{id}")
    public ModelAndView updateNewsPage(@PathVariable String id){
        ModelAndView model = new ModelAndView("update-news");
        ModelAndView modelNull = new ModelAndView("redirect:/news/list");
        News news = newsService.findById(id);
        if(news == null){
            modelNull.addObject("errorNull","News's id is not exist");
            return modelNull;
        }
        model.addObject("news", news);
        return model;
    }

    @PostMapping("/news/update")
    public ModelAndView updateNews(@Valid @ModelAttribute("news") News news, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        ModelAndView modelError = new ModelAndView("update-news");
        ModelAndView model = new ModelAndView("redirect:/news/list");
        if(bindingResult.hasErrors()){
            return modelError;
        }
        news.setPostDate(LocalDate.now());
        news.setContent(request.getParameter("content"));
        newsService.save(news);
        redirectAttributes.addFlashAttribute("success", "Update News Successfully!");
        return model;
    }
}
