package com.amadeus.horas_extras.adapter.daos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empleado")
public class Employ {

    @Id
    @Column(name = "documento")
    private String document;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastname;
    @Column(name = "correo")
    private String mail;
    @Column(name = "numero_telefono")
    private String numberTelephone;
    @Column(name = "cargo")
    private String position;
    @Column(name = "salario")
    private BigDecimal salary;
    private String area;


}
