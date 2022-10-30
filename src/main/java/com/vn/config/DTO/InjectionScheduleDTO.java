package com.vn.config.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class InjectionScheduleDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private String place;
    private String note;
    private String vaccineID;
}
