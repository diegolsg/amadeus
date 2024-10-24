package com.amadeus.horas_extras.domain.port.repository;

import com.amadeus.horas_extras.adapter.daos.entity.Boss;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BossRepository {

    List<Boss> getBosses();

}
