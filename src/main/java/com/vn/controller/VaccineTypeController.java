package com.vn.controller;

import com.vn.dto.VaccineTypeDTO;
import com.vn.model.VaccineType;
import com.vn.repository.VaccineRepository;
import com.vn.service.VaccineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class VaccineTypeController {
	
	@Autowired
    private VaccineTypeService vaccineTypeService;

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    HttpServletRequest request;

    @GetMapping(value = "/vaccineType/list")
    public ModelAndView viewListVaccineType() {
        ModelAndView model = new ModelAndView("listVaccineType");
        model.addObject("vaccineTypeList", vaccineTypeService.findAll());
        return model;
    }

    @GetMapping("/vaccineType/add")
    public ModelAndView createVaccineType(){
        ModelAndView model = new ModelAndView("createVaccineType");
    	model.addObject("member",new VaccineTypeDTO());
        return model;
    }

    @PostMapping("/vaccineType/add")
    public ModelAndView register(@Valid @ModelAttribute("vaccineType") VaccineTypeDTO vaccineTypeDTO, BindingResult bindingResult) {
        ModelAndView modelError = new ModelAndView("createVaccineType");
        ModelAndView model = new ModelAndView("redirect:/vaccineType/list");
        if(bindingResult.hasErrors()){

            modelError.addObject("message","Create Vaccine Type Failed !!!");
    		
            return modelError;
        }
    	vaccineTypeService.save(vaccineTypeDTO);
        return model;
    }

    @GetMapping(value = "/vaccineType/update/{id}")
    public ModelAndView updateVaccineType(@PathVariable("id") String id, @ModelAttribute("vaccineType") VaccineType vaccineType) {
        ModelAndView model = new ModelAndView("createVaccineType");
        VaccineType v = vaccineTypeService.findById(id);
        model.addObject("vaccineType", v);

        return model;
    }

    @PostMapping("/vaccineType/update")
    public ModelAndView updateVaccineType(@Valid @ModelAttribute("vaccineType") VaccineTypeDTO vaccineTypeDTO, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView("redirect:/vaccineType/list");
        ModelAndView modelError = new ModelAndView("createVaccineType");
        if (bindingResult.hasErrors()) {
            modelError.addObject("message", "Update Vaccine Type Failed !!!");
            return modelError;
        }
        vaccineTypeService.update(vaccineTypeDTO);
        return model;

    }

    @PostMapping("/vaccineType/update/status")
    public ModelAndView updateVaccineTypeStatus(@RequestParam(value = "ids") List<String> ids,  @RequestParam(value = "status", defaultValue = "false") Boolean inactive) {
        ModelAndView model = new ModelAndView("redirect:/vaccineType/list");
        vaccineTypeService.upDateStatus(ids, inactive);
        vaccineTypeService.upDateStatusVaccine(ids, inactive);

        return model;

   }



}
