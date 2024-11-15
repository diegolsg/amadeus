package com.amadeus.horas_extras.domain.model;


import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtrasHoursModel {

    private int id;
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
    private Double valueday;
    private Double totalHoursValue;
    private String observation;
    private Employ employs;
    private LocalDate createDate;
    private LocalDate updateDate;


}
