package com.vn.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Vaccine")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Vaccine implements Serializable{

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
    private LocalDate timeBeginNextInjection;

    @Column(name = "time_end_next_injection")
    private LocalDate timeEndNextInjection;

    @Column(length = 200)
    private String usage;

    @Column(length = 100, name = "vaccine_name")
    private String vaccineName;

    @ManyToOne
    @JoinColumn(name = "vaccine_type_id")
    private VaccineType vaccineType;

    @OneToMany(mappedBy = "vaccine")
    private Set<InjectionResult> injectionResults;

    @OneToMany(mappedBy = "vaccine")
    @JsonManagedReference
    private Set<InjectionSchedule> injectionSchedules;

    @Transient
    private Boolean status;

    public Boolean getStatus() {
        return true;

    }


}
