package com.vn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Vaccine_Type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VaccineType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "vaccine_type_id", nullable = false)
	private String id;
	
	@Column(name = "vaccine_type_name", length = 10, nullable = false)
	private String vaccineTypeName;

	@Column(length = 200)
	private String description;

	@Transient
	private MultipartFile imageFile;
	
	@Column
	private String imageUrl;

	@Column
	private Boolean vaccineTypeStatus = true;
	
	@OneToMany(mappedBy = "vaccineType",cascade = CascadeType.ALL)
	private Set<Vaccine> vaccines;
}
