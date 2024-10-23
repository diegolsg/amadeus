package com.amadeus.horas_extras.domain.port.service;

import com.amadeus.horas_extras.adapter.daos.mapper.BossMappers;
import com.amadeus.horas_extras.adapter.daos.repositoryImp.BossRepositoryImp;
import com.amadeus.horas_extras.domain.model.BossModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BossService {

    private BossRepositoryImp bossRepositoryImp;
    private BossMappers mappers;
    @Autowired
    public BossService(BossRepositoryImp bossRepositoryImp, BossMappers mappers) {
        this.bossRepositoryImp = bossRepositoryImp;
        this.mappers = mappers;
    }


    public List<BossModel> getBoss(){
        return mappers.toBossModels(bossRepositoryImp.getBosses());
    }
}
