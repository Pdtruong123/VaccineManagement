package com.vn.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate postDate;
}
