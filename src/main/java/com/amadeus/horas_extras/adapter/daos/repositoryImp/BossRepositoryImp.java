package com.amadeus.horas_extras.adapter.daos.repositoryImp;

import com.amadeus.horas_extras.adapter.daos.entity.Boss;
import com.amadeus.horas_extras.adapter.daos.jpa.BossJpaRepository;
import com.amadeus.horas_extras.adapter.daos.mapper.BossMappers;
import com.amadeus.horas_extras.domain.model.BossModel;
import com.amadeus.horas_extras.domain.port.repository.BossRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BossRepositoryImp implements BossRepository {
    private BossMappers mappers;
    private BossJpaRepository bossJpa;

    @Autowired
    public BossRepositoryImp(BossMappers mappers, BossJpaRepository bossJpa) {
        this.mappers = mappers;
        this.bossJpa = bossJpa;
    }

    @Override
    public List<BossModel> getBosses() {
        List<Boss> bossEntities = bossJpa.findAll();
        return bossEntities.stream()
                .map(mappers::fromBoss)
                .collect(Collectors.toList());
    }

    @Override
    public BossModel saveBoss(BossModel boss) {
        Boss bossEntity = mappers.toBossModels(boss);
        Boss savedEntity = bossJpa.save(bossEntity);
        return mappers.fromBoss(savedEntity);
    }

    @Override
    public BossModel updateBoss(BossModel boss) {
        if (bossJpa.existsById((long) boss.getId())) {
            Boss bossEntity = mappers.toBossModels(boss);
            Boss updatedEntity = bossJpa.save(bossEntity);
            return mappers.fromBoss(updatedEntity);
        }
        throw new EntityNotFoundException("Boss not found with id: " + boss.getId());
    }

    @Override
    public BossModel getBossById(Long id) {
        return bossJpa.findById((id))
                .map(mappers::fromBoss)
                .orElseThrow(() -> new EntityNotFoundException("Boss not found with id: " + id));
    }

    @Override
    public void deleteBoss(Long id) {
        if (bossJpa.existsById(id)) {
            bossJpa.deleteById(id);
        } else {
            throw new EntityNotFoundException("Boss not found with id: " + id);
        }
    }
}