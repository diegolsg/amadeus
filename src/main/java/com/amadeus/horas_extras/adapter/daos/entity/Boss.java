package com.amadeus.horas_extras.adapter.daos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "administrador")

public class Boss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastName;
    @Column(name = "correo")
    private String email;
    @Column(name = "numero_telefono")
    private String numberTelephone;
    private String area;
    @Column(name = "usuario")
    private String user;
    private String password;
    @Column(name = "fecha_creacion")
    private LocalDate createDate;
    @Column(name= "fecha_actualizacion")
    private LocalDate updateDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "boss")
    private List<Employ> employs;

}
