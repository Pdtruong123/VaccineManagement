package com.vn.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Vaccine_Type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VaccineType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "vaccine_type_id")
	private String id;
	
	@Column(length = 200)
	private String description;
	
	@Column(name = "vaccine_type_name", length = 50)
	private String vaccineTypeName;
	
	@OneToMany(mappedBy = "vaccineType")
	private Set<Vaccine> vaccines;
}
