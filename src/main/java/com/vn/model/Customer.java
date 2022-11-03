package com.vn.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

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

	@Id
	@Column(name = "customer_id", length = 36)
	private String id;
	
	private String address;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(length = 100)
	@Email
	private String email;
	
	@Column(name = "full_name", length = 100)
	private String fullName;
	
	private Integer gender;
	
	@Column(name = "identity_card", length = 12)
	private String identityCard;
	
	private String password;
	
	@Column(length = 20)
	private String phone;
	
	@Column(name = "user_name")
	private String userName;
	
	@OneToMany(mappedBy = "customer")
	private Set<InjectionResult> injectionResults;
}
