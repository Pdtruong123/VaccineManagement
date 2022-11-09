package com.vn.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import com.vn.util.GenerateID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Injection_Schedule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class InjectionSchedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_injection")
    @GenericGenerator(name = "ID_injection", strategy = "com.vn.util.GenerateID", parameters = {
            @org.hibernate.annotations.Parameter(name = GenerateID.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(name = GenerateID.VALUE_PREFIX_PARAMATER, value = "Injection_"),
            @org.hibernate.annotations.Parameter(name = GenerateID.NUMBER_FORMAT_PARAMETER, value = "%05d")

    })
    @Column(name = "injection_schedule_id", length = 36)
    private String id;

    @Column(length = 1000)
    private String description;
    @Column(name = "end_date")
    private LocalDate endDate;

    private String place;

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    @Column(name = "start_date")
    private LocalDate startDate;

    //    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;

    @Transient
    private String status;

    public String getStatus() {
        if (endDate.isBefore(LocalDate.now()) && vaccine.getStatus() != null && vaccine.getStatus() == true) {
            status = "Open";
        }
        if (!endDate.isBefore(LocalDate.now()) && vaccine.getStatus() != null && vaccine.getStatus() == true) {
            status = "Not yet";
        }
        if (!(vaccine.getStatus() != null && vaccine.getStatus()) && endDate.isBefore(LocalDate.now())) {
            status = "Over";
        }
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
