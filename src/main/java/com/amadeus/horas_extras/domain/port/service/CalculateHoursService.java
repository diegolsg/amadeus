package com.amadeus.horas_extras.domain.port.service;

import com.amadeus.horas_extras.adapter.api.dtos.ExtraHoursDto;
import com.amadeus.horas_extras.adapter.daos.entity.ExtraHours;
import com.amadeus.horas_extras.adapter.daos.jpa.ConfigHoursJpaRepository;
import com.amadeus.horas_extras.adapter.daos.jpa.EmployJpaRepository;
import com.amadeus.horas_extras.adapter.daos.jpa.HoursJpaRepository;
import com.amadeus.horas_extras.adapter.daos.mapper.HoursExtraMappers;
import com.amadeus.horas_extras.domain.model.EmployModel;
import com.amadeus.horas_extras.domain.model.ExtrasHoursModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class CalculateHoursService {

    private HoursJpaRepository hoursJpaRepository;
    private EmployJpaRepository employRepository;
    private HoursExtraMappers mappers;
    private ConfigHoursJpaRepository configHoursJpaRepository;


    @Autowired
    public CalculateHoursService(HoursJpaRepository hoursJpaRepository,
                                 EmployJpaRepository employRepository,
                                 HoursExtraMappers mappers) {
        this.hoursJpaRepository = hoursJpaRepository;
        this.employRepository = employRepository;
        this.mappers = mappers;
    }

    public ExtrasHoursModel dayTimeHours(ExtraHoursDto extraHoursDto) {
        int hourDayHoliday = 0;
        int hourNigthHoliday = 0;
        int hourDay = 0;
        int hourNigth = 0;
        LocalDateTime startHour = extraHoursDto.getStartHours();
        LocalDateTime endHour = extraHoursDto.getEndHours();

        ExtraHours entity = new ExtraHours();
        entity.setStartHours(startHour);
        entity.setEndHours(endHour);

        int intervaloMinutos = 1;
        for (LocalDateTime fechaActual = startHour; fechaActual.isBefore(endHour); fechaActual = fechaActual.plusMinutes(intervaloMinutos)) {
            DayOfWeek dayWeek = fechaActual.getDayOfWeek();
            LocalDate date = fechaActual.toLocalDate();
            int h = fechaActual.getHour();
            if (h < 6 || h >= 21) {
                if (dayWeek.name().equals("SUNDAY")) {
                    hourNigthHoliday++;
                } else {
                    hourNigth++;
                }
            } else {
                if (dayWeek.name().equals("SUNDAY")) {
                    hourDayHoliday++;
                } else {
                    hourDay++;
                }
            }
        }
        entity.setDayTimeHours(Double.parseDouble(convertToFractionalHours(hourDay).replace(",", ".")));
        entity.setNightTimeHours(Double.parseDouble(convertToFractionalHours(hourNigth).replace(",", ".")));
        entity.setDayHolidayHours(Double.parseDouble(convertToFractionalHours(hourDayHoliday).replace(",", ".")));
        entity.setNightHolidayHours(Double.parseDouble(convertToFractionalHours(hourNigthHoliday).replace(",", ".")));
        // entity.setValueday(entity.getEmploys().getSalary()/(30.0)/(8.0)*(2.0)*(0.35));
        entity.setUpdateDate(LocalDate.now());
        ExtraHours savedEntity = hoursJpaRepository.save(entity);

        return mappers.fromExtraHours(savedEntity);
    }


    public String convertToFractionalHours ( int totalMinutes){
        double hours = totalMinutes / 60.0;
        return String.format("%.2f", hours);  // Muestra el valor con dos decimales
    }

    public Double getDayValue(String document){
       // EmployModel employModel =
        return null;
    }

}
