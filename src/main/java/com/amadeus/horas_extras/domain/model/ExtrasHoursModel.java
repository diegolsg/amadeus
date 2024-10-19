package com.amadeus.horas_extras.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtrasHoursModel {

    private LocalDateTime startHours ;
    private LocalDateTime endHours ;
    private Double dayTimeHours;
    private Double nightTimeHours;
    private Double dayHolidayHours;
    private Double nightHolidayHours;
    private BigDecimal valuedayhours;
    private BigDecimal valuenighthours;
    private BigDecimal valueDayHollidayHours;
    private BigDecimal valueNightHolidayHours;
    private BigDecimal valueday;
    private Float totalHours;

}