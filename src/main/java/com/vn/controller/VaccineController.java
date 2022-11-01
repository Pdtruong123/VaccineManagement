package com.vn.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.model.Vaccine;
import com.vn.service.VaccineService;

@Controller
public class VaccineController {
	
	@Autowired
	VaccineService vaccineService;
	
	@Autowired
	HttpServletRequest request;
	
	@GetMapping(value = "/vaccine/list")
	public String viewListVaccine(Model model, @RequestParam(name ="p", required = false, defaultValue = "0") Integer p,
												@RequestParam(name ="size",required = false, defaultValue = "5") Integer size) {
		
		Pageable pageable = PageRequest.of(p,size);
		Page<Vaccine> vaccines = vaccineService.findAll(pageable);
		model.addAttribute("vaccineList",vaccines);
		vaccines.getTotalElements();
		return "vaccine-list";
	}
	
	@PostMapping(value = "/vaccine/search")
	public String searchVaccine(Model model, @RequestParam(name ="p", required = false, defaultValue = "0") Integer p,
			@RequestParam(name ="size",required = false, defaultValue = "5") Integer size) {
		
		String name = request.getParameter("searchVaccine");
		Pageable pageable = PageRequest.of(p,size);
		Page<Vaccine> vaccines = vaccineService.findByVaccineNameContaining(name,pageable);
		
		if (vaccines.isEmpty()) {
			model.addAttribute("msg","No data found!");
		}
		model.addAttribute("vaccineList",vaccines);
		
		return "vaccine-list";
	}
	
	@GetMapping(value = "/vaccine/add")
	public String viewAddVaccine() {
		return "vaccine-create";
	}
}
