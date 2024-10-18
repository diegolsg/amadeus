package com.amadeus.horas_extras.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "administrador")

public class Boss {
    @Id
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastname;
    @Column(name = "correo")
    private String mail;
    @Column(name = "numero_telefono")
    private String numberTelephone;
    @Column(name = "usuario")
    private String user;
    @Column(name="contrasena")
    private String password;
    @Column(name = "fecha_creacion")
    private LocalDate createDate;
    @Column(name= "fecha_actualizacion")
    private LocalDate updateDate;

}
