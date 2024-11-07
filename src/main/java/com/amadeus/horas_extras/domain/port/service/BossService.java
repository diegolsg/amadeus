package com.amadeus.horas_extras.domain.port.service;

import com.amadeus.horas_extras.adapter.daos.repositoryImp.BossRepositoryImp;
import com.amadeus.horas_extras.domain.model.BossModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BossService {


    private final BossRepositoryImp bossRepository;

    @Autowired
    public BossService(BossRepositoryImp bossRepository) {
        this.bossRepository = bossRepository;
    }


    public List<BossModel> getAllBosses() {
        return bossRepository.getBosses();
    }


    public BossModel getBossById(Long id) {
        return bossRepository.getBossById(id);
    }


    public BossModel createBoss(BossModel bossModel) {
        return bossRepository.saveBoss(bossModel);
    }


    public BossModel updateBoss(BossModel bossModel) {
//        if (bossModel.getId() null) {
//            throw new IllegalArgumentException("Boss ID cannot be null for update operation");
//        }
        return null;
    }


    public void deleteBoss(Long id) {
        bossRepository.deleteBoss(id);
    }
}
