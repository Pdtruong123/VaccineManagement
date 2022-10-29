package com.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VaccineTypeController {
    @GetMapping("/listVaccineType")
    public String vaccineTypeList(){

        return "listVaccineType";
    }

    @GetMapping("/vaccineTypeCreate")
    public String vaccineTypeCreate(){

        return "createVaccineType";
    }

}
