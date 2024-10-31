package com.amadeus.horas_extras.domain.port.service;

import com.amadeus.horas_extras.adapter.api.dtos.ExtraHoursDto;
import com.amadeus.horas_extras.adapter.daos.mapper.HoursExtraMappers;
import com.amadeus.horas_extras.adapter.daos.repositoryImp.ExtraHoursRepositoryImp;
import com.amadeus.horas_extras.domain.model.ExtrasHoursModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ExtraHoursService {

    private final ExtraHoursRepositoryImp extraHoursRepository;
    @Autowired
    public ExtraHoursService(ExtraHoursRepositoryImp extraHoursRepository) {
        this.extraHoursRepository = extraHoursRepository;
    }

    public List<ExtrasHoursModel> getAllHours() {
        return extraHoursRepository.getAllHours();
    }

    // Guardar horas extras
    public ExtrasHoursModel saveHours(ExtraHoursDto extraHours) {
        return extraHoursRepository.saveHours(extraHours);
    }

    public ExtrasHoursModel updateHours(ExtrasHoursModel extraHours) {
       return null;
    }

    public void deleteHours(int idExtraHours) {
        extraHoursRepository.deleteHours(idExtraHours);
    }

    public List<ExtrasHoursModel> getHoursByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return extraHoursRepository.getHoursByDate(startDate, endDate);
    }

    public List<ExtrasHoursModel> getHoursByDocument(String document) {
        return extraHoursRepository.getHoursByDocument(document);
    }
}
