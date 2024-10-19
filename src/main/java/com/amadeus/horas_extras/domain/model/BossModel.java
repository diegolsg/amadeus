package com.amadeus.horas_extras.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BossModel {
    private String name;
    private String lastname;
    private String mail;
    private String numberTelephone;
    private String user;
    private String password;
    private LocalDate createDate;
    private LocalDate updateDate;
}
