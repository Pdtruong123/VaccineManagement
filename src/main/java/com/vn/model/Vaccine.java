package com.vn.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Vaccine")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Vaccine {

	@Id
	@Column(name = "vaccine_id", length = 36)
	private String id;
	
	@Column(length = 200)
	private String contraindication;
	
	@Column(length = 200)
	private String indication;
	
	@Column(name = "number_of_injection")
	private Integer numberOfInjection;
	
	@Column(length = 50)
	private String origin;
	
	@Column(name = "time_begin_next_injection")
	private Date timeBeginNextInjection;
	
	@Column(name = "time_end_next_injection")
	private Date timeEndNextInjection;
	
	@Column(length = 200)
	private String usage;
	
	@Column(length = 100, name = "vaccine_name")
	private String vaccineName;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "vaccine_type_id")
	private VaccineType vaccineType;
	
	@OneToMany(mappedBy = "vaccine")
	private Set<InjectionResult> injectionResults;
	
	@OneToMany(mappedBy = "vaccine")
	private Set<InjectionSchedule> injectionSchedules;
	
	@Column(name = "status")	
	private Boolean status;

	public Vaccine(String id, String contraindication, String indication, Integer numberOfInjection, String origin,
			Date timeBeginNextInjection, Date timeEndNextInjection, String usage, String vaccineName,
			Boolean status,VaccineType vaccineType) {
		super();
		this.id = id;
		this.contraindication = contraindication;
		this.indication = indication;
		this.numberOfInjection = numberOfInjection;
		this.origin = origin;
		this.timeBeginNextInjection = timeBeginNextInjection;
		this.timeEndNextInjection = timeEndNextInjection;
		this.usage = usage;
		this.vaccineName = vaccineName;
		this.status = status;
		this.vaccineType = vaccineType;
	}

	@Override
	public String toString() {
		return "Vaccine [id=" + id + ", contraindication=" + contraindication + ", indication=" + indication
				+ ", numberOfInjection=" + numberOfInjection + ", origin=" + origin + ", timeBeginNextInjection="
				+ timeBeginNextInjection + ", timeEndNextInjection=" + timeEndNextInjection + ", usage=" + usage
				+ ", vaccineName=" + vaccineName + ", status=" + status + "]";
	}
	
	
	
	
	
	
}
