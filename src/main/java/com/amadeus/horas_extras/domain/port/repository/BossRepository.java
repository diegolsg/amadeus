package com.amadeus.horas_extras.domain.port.repository;

import com.amadeus.horas_extras.adapter.daos.entity.Boss;
import com.amadeus.horas_extras.domain.model.BossModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BossRepository {

    List<BossModel> getBosses();

    BossModel saveBoss(BossModel boss);

    BossModel updateBoss(BossModel boss);

    BossModel getBossById(Long id);

    void deleteBoss(Long id);
}