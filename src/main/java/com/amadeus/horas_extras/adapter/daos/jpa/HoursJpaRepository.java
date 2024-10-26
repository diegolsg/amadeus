package com.amadeus.horas_extras.adapter.daos.jpa;

import com.amadeus.horas_extras.adapter.daos.entity.ExtraHours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface HoursJpaRepository extends JpaRepository<ExtraHours,Integer> {

    List<ExtraHours> findByStartHoursBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<ExtraHours> findByEmploys_Document(String document);
}
