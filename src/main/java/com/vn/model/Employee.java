package com.vn.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.vn.util.GenerateID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Employee_ID")
    @GenericGenerator(name = "Employee_ID", strategy = "com.vn.util.GenerateID", parameters = {
            @org.hibernate.annotations.Parameter(name = GenerateID.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(name = GenerateID.VALUE_PREFIX_PARAMATER, value = "Employee_"),
            @org.hibernate.annotations.Parameter(name = GenerateID.NUMBER_FORMAT_PARAMETER, value = "%05d")
    })
    @Column(name = "employee_id", length = 36, nullable = false)
    private String id;

    @Column(columnDefinition = "nvarchar(255)")
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(length = 100)
    @Email
    @NotEmpty
    private String email;

    @Column(name = "employee_name", length = 100,columnDefinition = "nvarchar(100)")
    @NotBlank(message = "Please fill name of employee")
    private String employeeName;

    private Integer gender;

    @Transient
    private String customFileInputHidden;

    @Transient
    private MultipartFile imageFile;

    @Column
    private String imageUrl;


    @Column(length = 20)
    @NotBlank(message = "Please fill phone number of employee")
    private String phone;

    @Column(length = 100,columnDefinition = "nvarchar(100)")
    private String position;


    @Column(name = "working_place",columnDefinition = "nvarchar(255)")
    private String workingPlace;

}
