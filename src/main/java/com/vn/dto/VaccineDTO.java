package com.vn.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.vn.model.VaccineType;

import lombok.Data;

@Data
public class VaccineDTO {
	
	
	private String id;
	
	
	private String contraindication;
	
	
	private String indication;
	
	
	private Integer numberOfInjection;
	
	
	private String origin;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date timeBeginNextInjection;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date timeEndNextInjection;
	
	
	private String usage;
	
	private Boolean status = false;
	
	private VaccineType vaccineType;
	
	private String vaccineName;

}
