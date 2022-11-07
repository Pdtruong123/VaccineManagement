package com.vn.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VaccineTypeDTO {
	
	private String id;
	
	private String vaccineTypeName;
	
	private String description;
	
	private MultipartFile imageFile;
	
	private String imageUrl;

	private Boolean vaccineTypeStatus = true;
	
}
