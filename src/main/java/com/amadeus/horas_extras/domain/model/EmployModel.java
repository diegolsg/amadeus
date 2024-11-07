package com.amadeus.horas_extras.domain.model;


import com.amadeus.horas_extras.adapter.daos.entity.Position;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployModel {
    private String document;
    private String name;
    private String lastName;
    private String email;
    private String numberTelephone;
    private Position position;
    private Double salary;
    private String user;
    private String password;
    private String area;
    private LocalDate createDate;
    private LocalDate updateDate;

}
