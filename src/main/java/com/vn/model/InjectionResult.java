package com.vn.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.vn.annotation.StartBeforeEndDateValid;
import com.vn.annotation.StartDateAfterNowValid;
import com.vn.annotation.StartEndDateable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Injection_Result")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@StartBeforeEndDateValid
@StartDateAfterNowValid

public class InjectionResult implements StartEndDateable, Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "injectionId")
	@GenericGenerator(name = "injectionId", strategy = "com.vn.model.StringSuffixSequenceGenerator",
			parameters ={
					@org.hibernate.annotations.Parameter(name = StringSuffixSequenceGenerator.INCREMENT_PARAM, value = "1"),
					@org.hibernate.annotations.Parameter(name = StringSuffixSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
			} )
	@Column(name = "Injection_result_id", length = 36)
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "injection_date")
	@Future(message = "")
	private LocalDate injectionDate;


	@Column(name = "injection_place")
	@NotBlank(message = "Please fill Injection Place")
	private String injectionPlace;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "next_injection_date")
	private LocalDate nextInjectionDate;
	
	@Column(name = "number_of_injection")
	@NotNull(message = "Please fill Number Of Injections")
	private Integer numberOfInjection;
	
	@Column(length = 100)
	@NotBlank(message = "Please select prevention")
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
