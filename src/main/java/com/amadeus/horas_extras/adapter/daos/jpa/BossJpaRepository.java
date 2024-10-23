package com.amadeus.horas_extras.adapter.daos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amadeus.horas_extras.entity.Boss;

public interface BossJpaRepository extends JpaRepository<Boss, Long> {
}
