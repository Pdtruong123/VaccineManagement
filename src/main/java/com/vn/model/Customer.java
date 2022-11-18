package com.vn.model;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerId")
	@GenericGenerator(name = "customerId", strategy = "com.vn.model.StringSuffixSequenceGenerator",
			parameters ={
					@org.hibernate.annotations.Parameter(name = StringSuffixSequenceGenerator.INCREMENT_PARAM, value = "1"),
					@org.hibernate.annotations.Parameter(name = StringSuffixSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
			} )
	@Column(name = "customer_id", length = 36)
	private String id;

	private String address;

	@Column(name = "date_of_birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;

	@Column(length = 100)
	@Email
	private String email;

	@Column(name = "full_name", length = 100)
	private String fullName;

	@Column(name = "gender")
	private Integer gender;

	@Column(name = "identity_card", length = 12)
	private String identityCard;

	@Column(name = "password")
	private String password;

	@Transient
	private String confirmPassword;

	@Column(length = 20)
	private String phone;

	@Transient
	private String captcha;

	@Transient
	private String code;

	@Column(name = "user_name")
	private String userName;

	@OneToMany(mappedBy = "customer")
	private Set<InjectionResult> injectionResults;

	@Transient
	public int getCountNumberOfInjection(){
		int total = injectionResults.stream().map(x -> {
			return x.getNumberOfInjection();
		}).reduce(0, (subtotal, element) -> subtotal + element);
		return total;
	}
	
	
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
	private List<UserRole> userRoles;


	@Override
	public String toString() {
		return "Customer{" +
				"id='" + id + '\'' +
				", address='" + address + '\'' +
				", dateOfBirth=" + dateOfBirth +
				", email='" + email + '\'' +
				", fullName='" + fullName + '\'' +
				", gender=" + gender +
				", identityCard='" + identityCard + '\'' +
				", password='" + password + '\'' +
				", confirmPassword='" + confirmPassword + '\'' +
				", phone='" + phone + '\'' +
				", captcha='" + captcha + '\'' +
				", code='" + code + '\'' +
				", userName='" + userName + '\'' +
				'}';
	}
}
