package com.amadeus.horas_extras.adapter.daos.repositoryImp;

import com.amadeus.horas_extras.adapter.daos.entity.Boss;
import com.amadeus.horas_extras.adapter.daos.jpa.BossJpaRepository;
import com.amadeus.horas_extras.domain.port.repository.BossRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BossRepositoryImp implements BossRepository {

    private BossJpaRepository bossJpa;
    @Autowired
    public BossRepositoryImp(BossJpaRepository bossJpa) {
        this.bossJpa = bossJpa;
    }

    @Override
    public List<Boss> getBosses() {
        return bossJpa.findAll();
    }
}
