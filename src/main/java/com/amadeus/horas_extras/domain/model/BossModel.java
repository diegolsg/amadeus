package com.amadeus.horas_extras.domain.model;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BossModel {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String numberTelephone;
    private String area;
    private String user;
    private String password;
    private LocalDate createDate;
    private LocalDate updateDate;
}
