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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	private Integer gender;

	@Column(name = "identity_card", length = 12)
	private String identityCard;

	@Column(name = "password")
	private String password;

	@Transient
	private String rePassword;

	@Column(length = 20)
	private String phone;

	@Column(name = "user_name")
	private String userName;

	@OneToMany(mappedBy = "customer")
	private Set<InjectionResult> injectionResults;

	@Override
	public String toString() {
		return "Customer [id=" + id + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", email=" + email
				+ ", fullName=" + fullName + ", gender=" + gender + ", identityCard=" + identityCard + ", password="
				+ password + ", rePassword=" + rePassword + ", phone=" + phone + ", userName=" + userName
				+ ", injectionResults=" + injectionResults + "]";
	}

	
}
