package com.vn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.vn.model.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vn.dto.VaccineTypeDTO;
import com.vn.model.VaccineType;
import com.vn.repository.VaccineTypeRepository;
import com.vn.service.VaccineTypeService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VaccineTypeController {
	
	@Autowired
    private VaccineTypeService vaccineTypeService;
    
    @Autowired
    private VaccineTypeRepository vaccineTypeRepository;
    
    
//    @GetMapping("/listVaccineType")
//    public String vaccineTypeList(Model model){
//    	List<VaccineType> list = vaccineTypeService.findAll();
//    	model.addAttribute("list",list);
//        return "listVaccineType";
//    }
    @GetMapping(value = "/vaccine/listVaccineType")
    public String viewListVaccineType(Model model, @RequestParam(name ="p", required = false, defaultValue = "0") Integer p,
                                  @RequestParam(name ="size",required = false, defaultValue = "5") Integer size) {

        Pageable pageable = PageRequest.of(p,size);
        Page<VaccineType> vaccineTypes = vaccineTypeService.findAll(pageable);
        model.addAttribute("vaccineTypeList",vaccineTypes);
        vaccineTypes.getTotalElements();
        return "listVaccineType";
    }

    @GetMapping("/createVaccineType")
    public String createVaccineType(Model model){
    	model.addAttribute("member",new VaccineTypeDTO());
        return "createVaccineType";
    }

    @PostMapping("/createVaccineType")
    public String register(@Valid @ModelAttribute("vaccineType") VaccineTypeDTO vaccineTypeDTO, BindingResult bindingResult, Model model) {
    	if(bindingResult.hasErrors()){
    		
            model.addAttribute("message","Create Vaccine Type Failed !!!");
    		
            return "createVaccineType";
        }
    	vaccineTypeService.save(vaccineTypeDTO);
        return "redirect:/listVaccineType";
    }
}
