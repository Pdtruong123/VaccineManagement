package com.vn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vn.dto.VaccineDTO;
import com.vn.model.Vaccine;
import com.vn.model.VaccineType;
import com.vn.service.VaccineService;
import com.vn.service.VaccineTypeService;

@Controller
public class VaccineController {
	
	@Autowired
	VaccineService vaccineService;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	VaccineTypeService vaccineTypeService;
	
	@GetMapping(value = "/vaccine/list")
	public String viewListVaccine(Model model, @RequestParam(name ="p", required = false, defaultValue = "0") Integer p,
												@RequestParam(name ="size",required = false, defaultValue = "2") Integer size,
												@ModelAttribute("msgAdd") String msgAdd) {
		
		Pageable pageable = PageRequest.of(p,size);
		Page<Vaccine> vaccines = vaccineService.findAll(pageable);
		model.addAttribute("vaccineList",vaccines);
		
		System.out.println(vaccines.getContent().size());
		if (size*(vaccines.getNumber()+1)>vaccines.getTotalElements()) {
			model.addAttribute("firstElement",size*p+1);
			model.addAttribute("lastElement",vaccines.getTotalElements());
		} else {
			model.addAttribute("firstElement",size*p+1);
			model.addAttribute("lastElement",size*(p+1));
		}
		model.addAttribute("msgAdd", msgAdd);
		return "vaccine/vaccine-list";
	}
	
	@PostMapping(value = "/vaccine/search")
	public String searchVaccine(Model model, @RequestParam(name ="p", required = false, defaultValue = "0") Integer p,
			@RequestParam(name ="size",required = false, defaultValue = "5") Integer size, RedirectAttributes redirectAttributes) {
		
		String name = request.getParameter("searchVaccine");
		Pageable pageable = PageRequest.of(p,size);
		Page<Vaccine> vaccines = vaccineService.findByVaccineNameContaining(name,pageable);
		
		if (vaccines.isEmpty()) {
			model.addAttribute("msg","No data found!");
		}
		model.addAttribute("vaccineList",vaccines);
		
		if (size*(vaccines.getNumber()+1)>vaccines.getTotalElements()) {
			model.addAttribute("firstElement",size*p+1);
			model.addAttribute("lastElement",vaccines.getTotalElements());
		} else {
			model.addAttribute("firstElement",size*p+1);
			model.addAttribute("lastElement",size*(p+1));
			
		}
		
		return "vaccine/vaccine-list";
	}
	
	@GetMapping(value = "/vaccine/add")
	public String viewAddVaccine(Model model) {
		List<VaccineType> vaccineTypeList = new ArrayList<>();
		vaccineTypeList = vaccineTypeService.findAll();
		
		model.addAttribute("vaccineTypeList",vaccineTypeList);
		model.addAttribute("vaccineDto",new VaccineDTO());
		
		return "vaccine/vaccine-create";
	}
	
	@PostMapping(value = "/vaccine/add")
	public String addVaccine(Model model,@Valid@ModelAttribute("vaccineDto") VaccineDTO vaccineDTO,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "vaccine/vaccine-create";
		}
		System.out.println(vaccineDTO.getStatus());
		if(vaccineService.hasVaccineById(vaccineDTO.getId())) {
			
			List<VaccineType> vaccineTypeList = new ArrayList<>();
			vaccineTypeList = vaccineTypeService.findAll();
			
			model.addAttribute("vaccineTypeList",vaccineTypeList);
			model.addAttribute("vaccineDto",new VaccineDTO());
			model.addAttribute("msgId","Id is already exists!");
			return "vaccine/vaccine-create";
		}
		
		vaccineService.save(vaccineDTO);
		redirectAttributes.addFlashAttribute("msgAdd","Create vaccine successfull!");
		return "redirect:/vaccine/list";
	}
	
	@PostMapping(value="/vaccine/update/makeInActive")
	public String updateInActive(@RequestParam String id) {
		Boolean status=false;
		vaccineService.updateInActive(status,id);
		return "redirect:/vaccine/list";
	}
	
}
