package com.amadeus.horas_extras.adapter.daos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.List;

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
    private String lastName;
    @Column(name = "correo")
    private String email;
    @Column(name = "numero_telefono")
    private String numberTelephone;
    @Column(name = "cargo")
    private Position position;
    @Column(name = "salario")
    private BigDecimal salary;
    private String area;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employs")
    private List<ExtraHours> extraHours;

    @ManyToOne(fetch = FetchType.LAZY)
    private Boss boss;


}
