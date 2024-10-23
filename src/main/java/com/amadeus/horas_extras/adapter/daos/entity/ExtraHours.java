package com.amadeus.horas_extras.adapter.daos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "horas_extras")

public class ExtraHours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column(name = "horainicio")
    private LocalDateTime startHours ;
   @Column(name = "horafin")
    private LocalDateTime endHours ;
   @Column(name = "horadiurna")
    private Double dayTimeHours;
   @Column(name = "horanocturna")
    private Double nightTimeHours;
   @Column(name = "horaDiurnaFestiva")
    private Double dayHolidayHours;
   @Column(name = "horaNocturnaFestiva")
    private Double nightHolidayHours;
   @Column(name = "valorHoraDiurna")
    private BigDecimal valuedayhours;
   @Column(name = "ValorHoraNocturna")
    private BigDecimal valuenighthours;
   @Column(name = "ValorHoraFestivaDiurna")
    private BigDecimal valueDayHollidayHours;
   @Column(name = "valorHoraFestivaNocturna")
    private BigDecimal valueNightHolidayHours;
   @Column(name = "valorDia")
    private BigDecimal valueday;
   @Column(name = "totalDeHoras")
    private Float totalHours;
   @ManyToOne(fetch = FetchType.LAZY)
    private Employ employs;


}
