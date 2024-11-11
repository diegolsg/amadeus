package com.amadeus.horas_extras.adapter.daos.jpa;

import com.amadeus.horas_extras.adapter.daos.entity.ConfigHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigHoursJpaRepository extends JpaRepository<ConfigHours,Long> {
}
