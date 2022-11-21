package com.vn.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.vn.model.VaccineType;

import lombok.Data;

@Data
public class VaccineDTO {
	
	@NumberFormat
	@Length(max = 10, min = 0)
	@NotBlank(message = "Pls fill input!")
	private String id;
	
	@Length(max = 200)
	private String contraindication;
	
	@Length(max = 200)
	private String indication;
	
	@Length(max = 200)
	private Integer numberOfInjection;
	
	@Length(max = 50)
	private String origin;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "Please input Date of vaccination with value greater or equal the current date")
	private Date timeBeginNextInjection;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "Please input Date of vaccination with value greater or equal the current date")
	private Date timeEndNextInjection;
	
	@Length(max = 200)
	private String usage;
	
	private Boolean status = false;
	
	private VaccineType vaccineType;
	
	@Length(max = 50, min = 0)
	@NotBlank(message = "Pls fill input!")
	private String vaccineName;

}
