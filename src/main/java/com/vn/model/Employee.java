package com.vn.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Employee implements Serializable {

	@Id
	@Column(name ="employee_id", length = 36)
	private Integer id;
	
	private String address;
	
	@Column(name ="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(length = 100)
	@Email
	private String email;
	
	@Column(name = "employee_name",length = 100)
	private String employeeName;
	
	private Integer gender;
	
	private String image;
	
	private String password;
	
	@Column(length = 20)
	private String phone;
	
	@Column(length = 100)
	private String position;
	
	private String userName;
	
	@Column(name = "working_place")
	private String workingPlace;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", email=" + email
				+ ", employeeName=" + employeeName + ", gender=" + gender + ", image=" + image + ", password="
				+ password + ", phone=" + phone + ", position=" + position + ", userName=" + userName
				+ ", workingPlace=" + workingPlace + "]";
	}
}
