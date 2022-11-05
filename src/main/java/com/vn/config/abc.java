package com.vn.config;

import com.vn.model.VaccineType;
import com.vn.repository.VaccineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vaccine1")
public class abc {
    @Autowired
    VaccineTypeRepository vaccineTypeRepository;
    @GetMapping("/list")
    public List<VaccineType> getList(){
        return vaccineTypeRepository.findAll();
    }
}
