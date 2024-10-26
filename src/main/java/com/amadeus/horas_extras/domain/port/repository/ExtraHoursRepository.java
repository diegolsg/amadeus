package com.amadeus.horas_extras.domain.port.repository;


import com.amadeus.horas_extras.domain.model.ExtrasHoursModel;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExtraHoursRepository {
    List<ExtrasHoursModel> getAllHours();
    ExtrasHoursModel saveHours(ExtrasHoursModel extraHours);
    ExtrasHoursModel updateHours(ExtrasHoursModel extraHours);
}
