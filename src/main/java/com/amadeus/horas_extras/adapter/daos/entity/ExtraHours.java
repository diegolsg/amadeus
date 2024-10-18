package com.amadeus.horas_extras.adapter.daos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "horas")

public class ExtraHours {

    private int id;
   @Column(name = "horainicio")
    private LocalDateTime startHours ;
   @Column(name = "horafin")
    private LocalDateTime endHours ;
   @Column(name = "horadiurna")
    private Double dayTimeHours;
   @Column(name = "horanocturna")
    private Double nightTimeHours;
   @Column(name = "hora")
    private Double dayHolidayHours;
   @Column(name = "")
    private Double nightHolidayHours;
   @Column(name = "")
    private BigDecimal valuedayhours;
   @Column(name = "")
    private BigDecimal valuenighthours;
   @Column(name = "")
    private BigDecimal valueDayHollidayHours;
   @Column(name = "")
    private BigDecimal valueNightHolidayHours;
   @Column(name = "")
    private BigDecimal valueday;


}
