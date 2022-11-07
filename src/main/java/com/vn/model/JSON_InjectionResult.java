package com.vn.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JSON_InjectionResult {

    private String id;
    private LocalDate injectionDate;
    private String injectionPlace;
    private LocalDate nextInjectionDate;
    private String numberOfInjection;
    private String prevention;
    private Vaccine vaccine;

    @Override
    public String toString() {
        return "JSON_InjectionResult{" +
                "id='" + id + '\'' +
                ", injectionDate=" + injectionDate +
                ", injectionPlace='" + injectionPlace + '\'' +
                ", nextInjectionDate=" + nextInjectionDate +
                ", numberOfInjection='" + numberOfInjection + '\'' +
                ", prevention='" + prevention + '\'' +
                ", vaccine=" + vaccine.getVaccineName() +
                '}';
    }
}
