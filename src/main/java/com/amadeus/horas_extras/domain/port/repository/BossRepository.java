package com.amadeus.horas_extras.domain.port.repository;

import org.springframework.stereotype.Repository;
import com.amadeus.horas_extras.entity.Boss;
import java.util.List;

@Repository
public interface BossRepository {

    List<Boss> getBosses();

}
