package com.amadeus.horas_extras.domain.port.service;


import com.amadeus.horas_extras.adapter.daos.repositoryImp.ConfigHoursRepositoryImp;
import com.amadeus.horas_extras.domain.model.ConfigHoursModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigHoursService {
    private ConfigHoursRepositoryImp repositoryImp;
    @Autowired
    public ConfigHoursService(ConfigHoursRepositoryImp repositoryImp) {
        this.repositoryImp = repositoryImp;
    }
    public ConfigHoursModel saveConfigHours(ConfigHoursModel configHoursModel) {
        return repositoryImp.saveConfigHours(configHoursModel);
    }


    public ConfigHoursModel updateConfigHour(ConfigHoursModel configHoursModel) {
        return repositoryImp.updateConfigHour(configHoursModel);

    }
}
