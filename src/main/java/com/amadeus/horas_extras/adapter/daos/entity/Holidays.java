package com.amadeus.horas_extras.adapter.daos.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Holidays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;

    @ManyToOne(FetchType.LAZY)
    private ConfigHours configHours,

}
