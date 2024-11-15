package com.amadeus.horas_extras.adapter.daos.mapper;


import com.amadeus.horas_extras.adapter.daos.entity.ConfigHours;
import com.amadeus.horas_extras.domain.model.ConfigHoursModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ConfigHoursMappers {
    @Mappings({

            @Mapping(source = "id",target = "id"),
            @Mapping(source = "percentageNight",target = "percentageNight"),
            @Mapping(source = "percentageDaily",target = "percentageDaily"),
            @Mapping(source = "percentageHoliday",target = "percentageHoliday"),
            @Mapping(source = "holiday",target = "holiday"),
            @Mapping(source = "startHourDay",target = "startHourDay"),
            @Mapping(source = "endHourDay",target = "endHourDay"),
            @Mapping(source = "createDate",target = "createDate"),
            @Mapping(source = "updateDate",target = "updateDate")

    })
    ConfigHours toConfigHoursModel(ConfigHoursModel configHoursModel);

    @InheritInverseConfiguration
    ConfigHoursModel fromConfigHours(ConfigHours configHours);
}
