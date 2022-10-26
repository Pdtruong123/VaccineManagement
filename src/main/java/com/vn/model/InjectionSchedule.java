package com.vn.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Injection_Schedule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class InjectionSchedule {

	@Id
	@Column(name = "injection_schedule_id", length = 36)
	private String id;
	
	@Column(length = 1000)
	private String description;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	private String place;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@ManyToOne
	@JoinColumn(name = "vaccine_id")
	private Vaccine vaccine;
}
