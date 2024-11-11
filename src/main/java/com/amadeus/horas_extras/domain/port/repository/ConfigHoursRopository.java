package com.amadeus.horas_extras.domain.port.repository;

import com.amadeus.horas_extras.domain.model.ConfigHoursModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigHoursRopository {

    ConfigHoursModel saveConfigHours(ConfigHoursModel configHoursModel);

    ConfigHoursModel updateConfigHour(ConfigHoursModel configHoursModel);
}
