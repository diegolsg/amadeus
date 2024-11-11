package com.amadeus.horas_extras.adapter.daos.repositoryImp;



import com.amadeus.horas_extras.adapter.daos.entity.ConfigHours;
import com.amadeus.horas_extras.adapter.daos.jpa.ConfigHoursJpaRepository;
import com.amadeus.horas_extras.adapter.daos.mapper.ConfigHoursMappers;
import com.amadeus.horas_extras.domain.model.ConfigHoursModel;
import com.amadeus.horas_extras.domain.port.repository.ConfigHoursRopository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConfigHoursRepositoryImp implements ConfigHoursRopository {

    private ConfigHoursJpaRepository jpaRepository;
    private ConfigHoursMappers mappers;
    @Autowired
    public ConfigHoursRepositoryImp(ConfigHoursJpaRepository jpaRepository,
                                    ConfigHoursMappers mappers) {
        this.jpaRepository = jpaRepository;
        this.mappers = mappers;
    }


    @Override
    public ConfigHoursModel saveConfigHours(ConfigHoursModel configHoursModel) {
        ConfigHours entity = mappers.toConfigHoursModel(configHoursModel);
        ConfigHours savedEntity = jpaRepository.save(entity);
        return mappers.fromConfigHours(savedEntity);
    }

    @Override
    public ConfigHoursModel updateConfigHour(ConfigHoursModel configHoursModel) {
        if (jpaRepository.existsById((long) configHoursModel.getId())) {
            ConfigHours configEntity = mappers.toConfigHoursModel(configHoursModel);
            ConfigHours updatedEntity = jpaRepository.save(configEntity);
            return mappers.fromConfigHours(updatedEntity);
        }
        throw new EntityNotFoundException("Boss not found with id: " + configHoursModel.getId());

    }
}
