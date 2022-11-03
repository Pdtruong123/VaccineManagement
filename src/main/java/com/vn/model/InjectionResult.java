package com.vn.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Injection_Result")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class InjectionResult implements Serializable {

	@Id
	@Column(name = "Injection_result_id", length = 36)
	@NotBlank
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "injection_date")
	private LocalDate injectionDate;


	@Column(name = "injection_place")
	@NotBlank
	private String injectionPlace;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "next_injection_date")
	private LocalDate nextInjectionDate;
	
	@Column(name = "number_of_injection", length = 100)
	@NotBlank
	private String numberOfInjection;
	
	@Column(length = 100)
	@NotBlank
	private String prevention;
	
	
	@ManyToOne
	@JoinColumn(name = "vaccine_id")
	private Vaccine vaccine;

	@Override
	public String toString() {
		return "InjectionResult{" +
				"id='" + id + '\'' +
				", customer=" + customer +
				", injectionDate=" + injectionDate +
				", injectionPlace='" + injectionPlace + '\'' +
				", nextInjectionDate=" + nextInjectionDate +
				", numberOfInjection='" + numberOfInjection + '\'' +
				", prevention='" + prevention + '\'' +
				'}';
	}
}
