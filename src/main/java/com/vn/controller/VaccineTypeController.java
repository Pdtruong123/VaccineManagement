package com.vn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.vn.model.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.vn.dto.VaccineTypeDTO;
import com.vn.model.VaccineType;
import com.vn.repository.VaccineTypeRepository;
import com.vn.service.VaccineTypeService;

@Controller
public class VaccineTypeController {
	
	@Autowired
    private VaccineTypeService vaccineTypeService;

    @Autowired
    private VaccineTypeRepository vaccineTypeRepository;

    @Autowired
    HttpServletRequest request;

    @GetMapping(value = "/vaccineType/list")
    public String viewListVaccineType(Model model,
                                      @RequestParam(name ="p", required = false, defaultValue = "0") Integer p,
                                      @RequestParam(name ="size",required = false, defaultValue = "5") Integer size,
                                      @RequestParam(name ="search", required = false) String nameSearch
                                      ) {
        if (nameSearch==null) {
            Pageable pageable = PageRequest.of(p, size);
            Page<VaccineType> vaccineTypes = vaccineTypeService.findAll(pageable);
            model.addAttribute("vaccineTypeList", vaccineTypes);

            if (size * (vaccineTypes.getNumber() + 1) > vaccineTypes.getTotalElements()) {
                model.addAttribute("firstElement", size * p + 1);
                model.addAttribute("lastElement", vaccineTypes.getTotalElements());
            } else {
                model.addAttribute("firstElement", size * p + 1);
                model.addAttribute("lastElement", size * (p + 1));
            }
            model.addAttribute("nameSearch",nameSearch);
            return "listVaccineType";
        }else {
            Pageable pageable = PageRequest.of(p, size);
            Page<VaccineType> vaccineTypes = vaccineTypeService.findByVaccineTypeNameContaining(nameSearch,pageable);
            model.addAttribute("vaccineTypeList", vaccineTypes);

            if (size * (vaccineTypes.getNumber() + 1) > vaccineTypes.getTotalElements()) {
                model.addAttribute("firstElement", size * p + 1);
                model.addAttribute("lastElement", vaccineTypes.getTotalElements());
            } else {
                model.addAttribute("firstElement", size * p + 1);
                model.addAttribute("lastElement", size * (p + 1));
            }
            model.addAttribute("nameSearch",nameSearch);
            return "listVaccineType";
        }
    }

    @PostMapping(value = "/vaccineType/search")
    public String searchVaccineType(Model model) {

        String name = request.getParameter("searchVaccineType");
        return "redirect:/vaccineType/list/?search="+name+"";
    }

    @GetMapping("/vaccineType/add")
    public String createVaccineType(Model model){
    	model.addAttribute("member",new VaccineTypeDTO());
        return "createVaccineType";
    }

    @PostMapping("/vaccineType/add")
    public String register(@Valid @ModelAttribute("vaccineType") VaccineTypeDTO vaccineTypeDTO, BindingResult bindingResult, Model model) {
    	if(bindingResult.hasErrors()){
    		
            model.addAttribute("message","Create Vaccine Type Failed !!!");
    		
            return "createVaccineType";
        }
    	vaccineTypeService.save(vaccineTypeDTO);
        return "redirect:/vaccineType/list";
    }

    @GetMapping(value ="/vaccineType/update/{id}")
    public String updateVaccineType(@PathVariable("id") String id, @ModelAttribute("vaccineType") VaccineType vaccineType, Model model) {

        VaccineType v = vaccineTypeService.findById(id);
        model.addAttribute("vaccineType", v);

        return "createVaccineType";
    }
    @PostMapping("/vaccineType/update")
    public String updateVaccineType(@ModelAttribute("vaccineType") VaccineTypeDTO vaccineTypeDTO,  Model model ) {

        vaccineTypeService.update(vaccineTypeDTO);
        return "redirect:/vaccineType/list";

    }

    @PostMapping("/vaccineType/update/satus")
    public String updateVaccineTypeStatus(@RequestParam(value = "ids") List<String> ids,  @RequestParam(value = "status", defaultValue = "false") Boolean inactive) {

        vaccineTypeRepository.upDateStatus(ids, inactive);

        return "redirect:/vaccineType/list";
    }

    @GetMapping("/report/inject")
    public String reportInject(Model model){

        return "report-inject-result";
    }
    @GetMapping("/report/cus")
    public String reportCus(Model model){

        return "report-customer";
    }
    @GetMapping("/char/cus")
    public String chartCus(Model model){

        return "chart-customer";
    }
    @GetMapping("/char/inject")
    public String chartInject(Model model){

        return "chart-inject-result";
    }

}
