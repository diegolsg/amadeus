package com.amadeus.horas_extras.adapter.daos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "configuracion_horas")
public class ConfigHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="")
    private Long percentageNight;
    @Column(name="")
    private Long percentageDaily;
    @Column(name="")
    private Long percentageHoliday;
    @Column(name="")
    private LocalDate holiday;
    @Column(name="")
    private Time startHourDay;
    @Column(name="")
    private Time endHourDay;
    @Column(name = "fecha_creacion")
    private LocalDate createDate;
    @Column(name= "fecha_actualizacion")
    private LocalDate updateDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "configHours")
    private List<Holidays> holidays;
}
