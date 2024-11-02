package com.amadeus.horas_extras.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayModel {
    private int id;
    private LocalDate date;
}
