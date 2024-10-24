package com.amadeus.horas_extras.domain.model;


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
    private Double totalHours;
    private String observation;

}
