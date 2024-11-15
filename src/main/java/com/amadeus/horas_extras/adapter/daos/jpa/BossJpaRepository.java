package com.amadeus.horas_extras.adapter.daos.jpa;

import com.amadeus.horas_extras.adapter.daos.entity.Boss;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BossJpaRepository extends JpaRepository<Boss, Long> {
}
