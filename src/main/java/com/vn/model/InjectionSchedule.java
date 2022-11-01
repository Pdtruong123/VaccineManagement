package com.vn.model;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Injection_Schedule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class InjectionSchedule {

    @Id
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

    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;

    @Transient
    private String status;

    public String getStatus() {
        if (endDate.isBefore(LocalDate.now()) && vaccine.getStatus() == true) {
            status = "Open";
        } if(!endDate.isBefore(LocalDate.now())&& vaccine.getStatus() == true){
            status = "Not yet";
        }if(!vaccine.getStatus() && endDate.isBefore(LocalDate.now())){
            status="Over";
        }
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
