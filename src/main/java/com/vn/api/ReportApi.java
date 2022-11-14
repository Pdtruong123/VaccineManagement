package com.vn.api;

import com.vn.repository.ReportRepository;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/chart")
public class ReportApi {


    @Autowired
    ReportRepository reportRepository;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/injection-value")
    public List<Integer> getReport(@RequestParam("year") String year){

        return reportRepository.listValueInjectChart(year);
    }

}

