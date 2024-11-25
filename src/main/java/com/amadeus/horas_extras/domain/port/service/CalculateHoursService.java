package com.amadeus.horas_extras.domain.port.service;

import com.amadeus.horas_extras.adapter.api.dtos.ExtraHoursDto;
import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import com.amadeus.horas_extras.adapter.daos.entity.ExtraHours;
import com.amadeus.horas_extras.adapter.daos.jpa.ConfigHoursJpaRepository;
import com.amadeus.horas_extras.adapter.daos.jpa.EmployJpaRepository;
import com.amadeus.horas_extras.adapter.daos.jpa.HoursJpaRepository;
import com.amadeus.horas_extras.adapter.daos.mapper.HoursExtraMappers;
import com.amadeus.horas_extras.domain.model.EmployModel;
import com.amadeus.horas_extras.domain.model.ExtrasHoursModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

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

        ExtrasHoursModel entity = new ExtrasHoursModel();
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
        entity.setUpdateDate(LocalDate.now());
        entity.setCreateDate(LocalDate.now());
        entity.setDocumentNumber(extraHoursDto.getDocumentEmploy());
        entity.setValuedayhours(getDayValue(extraHoursDto.getDocumentEmploy()));
        entity.setObservation(extraHoursDto.getObservation());
        ExtraHours savedEntity = hoursJpaRepository.save(mappers.toExtraHoursModels(entity));

        return mappers.fromExtraHours(savedEntity);
    }


    public String convertToFractionalHours ( int totalMinutes){
        double hours = totalMinutes / 60.0;
        return String.format("%.2f", hours);  // Muestra el valor con dos decimales
    }

    public BigDecimal getDayValue(String document) {

        Optional<Employ> employOptional = employRepository.findByDocument(document);
        if (employOptional.isEmpty()) {
            throw new IllegalArgumentException("No se encontró un empleado con el documento proporcionado.");
        }

        Employ employ = employOptional.get();
        if (employ.getSalary() == null || employ.getSalary() <= 0) {
            throw new IllegalArgumentException("El salario del empleado es inválido.");
        }

        BigDecimal monthlySalary = BigDecimal.valueOf(employ.getSalary());
        BigDecimal dailyValue = monthlySalary.divide(BigDecimal.valueOf(230), 2, RoundingMode.HALF_UP);

        return dailyValue;
    }




}
