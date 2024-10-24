package com.amadeus.horas_extras.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployModel {
    private String document;
    private String name;
    private String lastName;
    private String email;
    private String numberTelephone;
    private String position;
    private BigDecimal salary;
    private String area;
}
