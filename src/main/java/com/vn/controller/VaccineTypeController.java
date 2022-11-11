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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VaccineTypeController {
	
	@Autowired
    private VaccineTypeService vaccineTypeService;

    @Autowired
    private VaccineTypeRepository vaccineTypeRepository;

    @Autowired
    HttpServletRequest request;

    @GetMapping(value = "/vaccineType/list")
    public ModelAndView viewListVaccineType(
                                      @RequestParam(name ="p", required = false, defaultValue = "0") Integer p,
                                      @RequestParam(name ="size",required = false, defaultValue = "5") Integer size,
                                      @RequestParam(name ="search", required = false) String nameSearch
                                      ) {
        ModelAndView model = new ModelAndView("listVaccineType");
        if (nameSearch==null) {
            Pageable pageable = PageRequest.of(p, size);
            Page<VaccineType> vaccineTypes = vaccineTypeService.findAll(pageable);
            model.addObject("vaccineTypeList", vaccineTypes);

            if (size * (vaccineTypes.getNumber() + 1) > vaccineTypes.getTotalElements()) {
                model.addObject("firstElement", size * p + 1);
                model.addObject("lastElement", vaccineTypes.getTotalElements());
            } else {
                model.addObject("firstElement", size * p + 1);
                model.addObject("lastElement", size * (p + 1));
            }
            model.addObject("nameSearch",nameSearch);
            model.addObject("size",size);
                return model;
        }else {
            Pageable pageable = PageRequest.of(p, size);
            Page<VaccineType> vaccineTypes = vaccineTypeService.findByVaccineTypeNameContaining(nameSearch,pageable);
            model.addObject("vaccineTypeList", vaccineTypes);

            if (size * (vaccineTypes.getNumber() + 1) > vaccineTypes.getTotalElements()) {
                model.addObject("firstElement", size * p + 1);
                model.addObject("lastElement", vaccineTypes.getTotalElements());
            } else {
                model.addObject("firstElement", size * p + 1);
                model.addObject("lastElement", size * (p + 1));
            }
            model.addObject("nameSearch",nameSearch);
            model.addObject("size",size);
            return model;
        }
    }

    @PostMapping(value = "/vaccineType/search")
    public ModelAndView searchVaccineType() {
        String name = request.getParameter("searchVaccineType");
        ModelAndView model = new ModelAndView("redirect:/vaccineType/list/?search="+name);

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

    @GetMapping(value ="/vaccineType/update/{id}")
    public ModelAndView updateVaccineType(@PathVariable("id") String id, @ModelAttribute("vaccineType") VaccineType vaccineType) {
        ModelAndView model = new ModelAndView("createVaccineType");
        VaccineType v = vaccineTypeService.findById(id);
        model.addObject("vaccineType", v);

        return model;
    }
    @PostMapping("/vaccineType/update")
    public ModelAndView updateVaccineType(@ModelAttribute("vaccineType") VaccineTypeDTO vaccineTypeDTO) {
        ModelAndView model = new ModelAndView("redirect:/vaccineType/list");
        vaccineTypeService.update(vaccineTypeDTO);
        return model;

    }

    @PostMapping("/vaccineType/update/status")
    public ModelAndView updateVaccineTypeStatus(@RequestParam(value = "ids") List<String> ids,  @RequestParam(value = "status", defaultValue = "false") Boolean inactive) {
        ModelAndView model = new ModelAndView("redirect:/vaccineType/list");
        vaccineTypeService.upDateStatus(ids, inactive);

        return model;

   }



}
