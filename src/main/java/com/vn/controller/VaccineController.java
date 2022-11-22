package com.vn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vn.dto.VaccineDTO;
import com.vn.model.Vaccine;
import com.vn.model.VaccineType;
import com.vn.service.VaccineService;
import com.vn.service.VaccineTypeService;
import com.vn.util.ReadFileExcel;

@Controller
public class VaccineController {

	@Autowired
	VaccineService vaccineService;

	@Autowired
	ReadFileExcel readFileExcel;

	@Autowired
	HttpServletRequest request;

	@Autowired
	VaccineTypeService vaccineTypeService;

	@GetMapping(value = "/vaccine/list")
	public ModelAndView viewListVaccine(@ModelAttribute("msg") String msg) {
		ModelAndView model = new ModelAndView("vaccineList");

		List<Vaccine> vaccines = vaccineService.findAll();
		model.addObject("vaccineList", vaccines);
		model.addObject("msg", msg);

		return model;

	}

	@GetMapping(value = "/vaccine/add")
	public ModelAndView viewAddVaccine() {
		ModelAndView model = new ModelAndView("vaccineCreate");
		List<VaccineType> vaccineTypeList = new ArrayList<>();
		vaccineTypeList = vaccineTypeService.findAllActice();

		model.addObject("vaccineTypeList", vaccineTypeList);
		model.addObject("vaccineDto", new VaccineDTO());

		return model;
	}

	@PostMapping(value = "/vaccine/add")
	public ModelAndView addVaccine(@Valid @ModelAttribute("vaccineDto") VaccineDTO vaccineDTO,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("vaccineCreate");
		if (bindingResult.hasErrors()) {
			return model;
		}
		List<VaccineType> vaccineTypeList = new ArrayList<>();
		vaccineTypeList = vaccineTypeService.findAllActice();
		if (vaccineService.hasVaccineById(vaccineDTO.getId())) {

			model.addObject("vaccineTypeList", vaccineTypeList);
			model.addObject("vaccineDto", vaccineDTO);
			model.addObject("msgId", "Id is already exists!");
			return model;
		}

		Vaccine vaccine = vaccineService.save(vaccineDTO);
		if (vaccine == null) {

			model.addObject("vaccineTypeList", vaccineTypeList);
			model.addObject("vaccineDto", vaccineDTO);
			model.addObject("msgTime", "Time to start next vaccination must be less than end time!");
			return model;
		}

		redirectAttributes.addFlashAttribute("msg", "Create vaccine successfull!");
		ModelAndView modelRedirectList = new ModelAndView("redirect:/vaccine/list");
		return modelRedirectList;
	}

	@PostMapping(value = "/vaccine/update/makeInActive")
	public ModelAndView updateInActive(@RequestParam List<String> ids) {
		Boolean status = false;
		vaccineService.updateStatus(ids, status);
		ModelAndView modelRedirectList = new ModelAndView("redirect:/vaccine/list");
		return modelRedirectList;
	}

	@GetMapping(value = "/vaccine/update/")
	public ModelAndView showUpdateVaccine(@RequestParam(name = "idUpdate", required = true) String idUpdate,
			RedirectAttributes redirectAttributes) {

		Vaccine vaccine = vaccineService.findVaccineById(idUpdate);
		ModelAndView modelRedirectList = new ModelAndView("redirect:/vaccine/list");
		if (vaccine == null) {
			redirectAttributes.addFlashAttribute("msg", "Id is not exists!");
			return modelRedirectList;
		}
		List<VaccineType> vaccineTypeList = new ArrayList<>();
		vaccineTypeList = vaccineTypeService.findAllActice();
		ModelAndView model = new ModelAndView("vaccineUpdate");

		VaccineDTO vaccineDTO = new VaccineDTO();
		vaccineDTO.setId(vaccine.getId());
		vaccineDTO.setStatus(vaccine.getStatus());
		vaccineDTO.setVaccineName(vaccine.getVaccineName());
		vaccineDTO.setVaccineType(vaccine.getVaccineType());
		vaccineDTO.setNumberOfInjection(vaccine.getNumberOfInjection());
		vaccineDTO.setUsage(vaccine.getUsage());
		vaccineDTO.setIndication(vaccine.getIndication());
		vaccineDTO.setContraindication(vaccine.getContraindication());
		vaccineDTO.setTimeBeginNextInjection(vaccine.getTimeBeginNextInjection());
		vaccineDTO.setTimeEndNextInjection(vaccine.getTimeEndNextInjection());
		vaccineDTO.setOrigin(vaccine.getOrigin());

		model.addObject("vaccineTypeList", vaccineTypeList);
		model.addObject("vaccineUpdate", vaccineDTO);
		return model;
	}

	@PostMapping(value = "/vaccine/update")
	public ModelAndView updateVaccine(@Valid @ModelAttribute("vaccineDto") VaccineDTO vaccineDTO,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("vaccineUpdate");
		if (bindingResult.hasErrors()) {
			return model;
		}
		List<VaccineType> vaccineTypeList = new ArrayList<>();
		vaccineTypeList = vaccineTypeService.findAllActice();
		Vaccine vaccine = vaccineService.findVaccineById(vaccineDTO.getId());
		if (vaccine == null) {
			model.addObject("msgId", "Id is not exists!");
			model.addObject("vaccineTypeList", vaccineTypeList);
			model.addObject("vaccineUpdate", vaccineDTO);

			return model;
		}
		Vaccine vaccineUpdate = vaccineService.update(vaccineDTO);

		if (vaccineUpdate == null) {
			model.addObject("vaccineTypeList", vaccineTypeList);
			model.addObject("msgTime", "Time to start next vaccination must be less than end time!");
			model.addObject("vaccineUpdate", vaccineDTO);
			return model;
		}
		ModelAndView modelRedirectList = new ModelAndView("redirect:/vaccine/list");
		redirectAttributes.addFlashAttribute("msg", "Update vaccine successfull!");
		return modelRedirectList;
	}
	
	@GetMapping("/vaccine/import")
	public ModelAndView viewImport() {
		ModelAndView modelImport = new ModelAndView("vaccineImport");
		return modelImport;
	}
	
	@PostMapping("/vaccine/import")
	public ModelAndView importVaccineFileExcel(@RequestParam("file") MultipartFile file) {
		ModelAndView modelImport = new ModelAndView("vaccineImport");
		if (readFileExcel.checkExcelFormat(file)) {
			vaccineService.save(file);
			modelImport.addObject("msg","Import successfull!");
			return modelImport;
		}else {
			modelImport.addObject("msg","Pls upload file excel!");
			return modelImport;
		}
		
	}
	
}
