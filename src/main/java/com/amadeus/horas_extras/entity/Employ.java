package com.amadeus.horas_extras.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empleado")
public class Employ {
    @Id
    private String documento;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String cargo;

}
