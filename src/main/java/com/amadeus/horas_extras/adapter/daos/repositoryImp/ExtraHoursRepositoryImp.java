package com.amadeus.horas_extras.adapter.daos.repositoryImp;

import com.amadeus.horas_extras.adapter.api.dtos.ExtraHoursDto;
import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import com.amadeus.horas_extras.adapter.daos.entity.ExtraHours;
import com.amadeus.horas_extras.adapter.daos.jpa.EmployJpaRepository;
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
    private EmployJpaRepository employRepository;
    private HoursExtraMappers mappers;
    private CalculateHours calculateHours;
    @Autowired
    public ExtraHoursRepositoryImp(HoursJpaRepository hoursJpaRepository,
                                   EmployJpaRepository employRepository,
                                   HoursExtraMappers mappers,
                                   CalculateHours calculateHours) {
        this.hoursJpaRepository = hoursJpaRepository;
        this.employRepository = employRepository;
        this.mappers = mappers;
        this.calculateHours = calculateHours;
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
    @Transactional
    public ExtrasHoursModel saveHours(ExtraHoursDto extraHoursDto) {
        String document = extraHoursDto.getDocumentEmploy();
        Employ employ = employRepository.findByDocument(document)
                .orElseThrow(() ->
                        new IllegalArgumentException("Empleado no encontrado con documento: " + document));


        ExtraHours entity = new ExtraHours();
        entity.setStartHours(extraHoursDto.getStartHours());
        entity.setEndHours(extraHoursDto.getEndHours());
        entity.setDayTimeHours(calculateHours.dayTimeHours(extraHoursDto.getStartHours(),extraHoursDto.getEndHours()));
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
