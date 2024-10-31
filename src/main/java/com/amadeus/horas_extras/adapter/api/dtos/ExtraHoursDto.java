package com.amadeus.horas_extras.adapter.api.dtos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtraHoursDto {
    private LocalDateTime startHours ;
    private LocalDateTime endHours ;
    private String documentEmploy;

}
