package com.amadeus.horas_extras.adapter.daos.repositoryImp;

import com.amadeus.horas_extras.adapter.daos.entity.ExtraHours;
import com.amadeus.horas_extras.adapter.daos.jpa.HoursJpaRepository;
import com.amadeus.horas_extras.adapter.daos.mapper.HoursExtraMappers;
import com.amadeus.horas_extras.domain.model.ExtrasHoursModel;
import com.amadeus.horas_extras.domain.port.repository.ExtraHoursRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ExtraHoursRepositoryImp implements ExtraHoursRepository {

    private HoursJpaRepository hoursJpaRepository;
    private HoursExtraMappers mappers;
    @Autowired
    public ExtraHoursRepositoryImp(HoursJpaRepository hoursJpaRepository, HoursExtraMappers mappers) {
        this.hoursJpaRepository = hoursJpaRepository;
        this.mappers = mappers;
    }

    public List<ExtrasHoursModel> getHoursByDate(LocalDateTime startDate, LocalDateTime endDate){
        return  mappers.toExtraHoursModel(hoursJpaRepository.findByStartHoursBetween(startDate,endDate));
    }

    public List<ExtrasHoursModel> getHoursByDocument(String document){
        return  mappers.toExtraHoursModel(hoursJpaRepository.findByEmploys_Document(document));
    }

    @Override
    public List<ExtrasHoursModel> getAllHours() {
        return mappers.toExtraHoursModel(hoursJpaRepository.findAll());
    }

    public ExtrasHoursModel saveHours(ExtrasHoursModel extraHours) {
        ExtraHours entity = mappers.toExtraHoursModels(extraHours);
        ExtraHours savedEntity = hoursJpaRepository.save(entity);
        return mappers.fromExtraHours(savedEntity);
    }


    public void deleteHours(int idExtraHours) {
        if (!hoursJpaRepository.existsById(idExtraHours)) {
            throw new IllegalArgumentException("Horas extras no encontradas con ID: " + idExtraHours);
        }
        hoursJpaRepository.deleteById(idExtraHours);
    }


    @Override
    public ExtrasHoursModel updateHours(ExtrasHoursModel extraHours) {

        ExtraHours existing = hoursJpaRepository.findById(extraHours.getId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Horas extras no encontradas con ID: " + extraHours.getId()));

        existing.setStartHours(extraHours.getStartHours());
        existing.setEndHours(extraHours.getEndHours());

        ExtraHours updatedEntity = hoursJpaRepository.save(existing);
        return mappers.fromExtraHours(updatedEntity);
    }
}
