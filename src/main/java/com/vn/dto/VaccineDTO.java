package com.vn.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.vn.annotation.StartDateAfterNowValid;
import com.vn.model.VaccineType;

import lombok.Data;

@Data
public class VaccineDTO {
	
	
	
	@Length(max = 10, min = 0,message = "Pls input is must small than 10 character!")
	@NotBlank(message = "Pls fill input!")
	@Pattern(regexp = "\\d+",message = "Pls input is must number!")
	private String id;
	
	@Length(max = 200,message = "Pls input is must small than 200 character!")
	private String contraindication;
	
	@Length(max = 200,message = "Pls input is must small than 200 character!")
	private String indication;
	
	@Max(value = 15,message = "Pls input is must small than 15!")
	@Pattern(regexp = "\\d+",message = "Pls input is must number!")
	private String numberOfInjection;
	
	@Length(max = 50,message = "Pls input is must small than 50 character!")
	private String origin;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "Please input Date of vaccination with value greater or equal the current date")
	private Date timeBeginNextInjection;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "Please input Date of vaccination with value greater or equal the current date")
	
	private Date timeEndNextInjection;
	
	@Length(max = 200,message = "Pls input is must small than 200 character!")
	private String usage;
	
	private Boolean status = false;
	
	private VaccineType vaccineType;
	
	@Length(max = 50, min = 0,message = "Pls input is must small than 50 character!")
	@NotBlank(message = "Pls fill input!")
	private String vaccineName;

}
