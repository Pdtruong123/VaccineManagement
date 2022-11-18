package com.vn.model;

import javax.persistence.*;

@Entity

public class DateReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String month;


}
