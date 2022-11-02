package com.vn.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Injection_Result")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class InjectionResult {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Injection_result_id", length = 36)
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Column(name = "injection_date")
	private LocalDate injectionDate;
	
	@Column(name = "injection_place")
	private String injectionPlace;
	
	@Column(name = "next_injection_date")
	private LocalDate nextInjectionDate;
	
	@Column(name = "number_of_injection", length = 100)
	private String numberOfInjection;
	
	@Column(length = 100)
	private String prevention;
	
	
	@ManyToOne
	@JoinColumn(name = "vaccine_id")
	private Vaccine vaccine;
}
