package com.vn.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateOfBirth;

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

	@Column
	private String capcha;

	@Column
	private String code;

	@Column(name = "user_name")
	private String userName;

	@OneToMany(mappedBy = "customer")
	private Set<InjectionResult> injectionResults;

	@Transient
	public int getCountNumberOfInjection(){
		int total = injectionResults.stream().map(x -> {
			return Integer.parseInt(x.getNumberOfInjection());
		}).reduce(0, (subtotal, element) -> subtotal + element);
		return total;
	}


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
				", capcha='" + capcha + '\'' +
				", code='" + code + '\'' +
				", userName='" + userName + '\'' +
				'}';
	}
}
