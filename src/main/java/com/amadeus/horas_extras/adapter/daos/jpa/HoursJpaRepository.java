package com.amadeus.horas_extras.adapter.daos.jpa;

import com.amadeus.horas_extras.adapter.daos.entity.ExtraHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoursJpaRepository extends JpaRepository<ExtraHours,Integer> {
}
