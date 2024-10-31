package com.amadeus.horas_extras.adapter.daos.repositoryImp;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class CalculateHours {

    public Double dayTimeHours(LocalDateTime startHour ,LocalDateTime endHour){
        DecimalFormat df = new DecimalFormat("#.0");
        Duration durationHour = Duration.between(startHour,endHour);
        double result = durationHour.toMinutes();
        return result/60.00;
    }

}
