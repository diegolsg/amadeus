package com.amadeus.horas_extras.domain.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigHoursModel {
    private Long id;
    private Long percentageNight;
    private Long percentageDaily;
    private Long percentageHoliday;
    private LocalDate holiday;
    private Time startHourDay;
    private Time endHourDay;
    private LocalDate createDate;
    private LocalDate updateDate;

}
