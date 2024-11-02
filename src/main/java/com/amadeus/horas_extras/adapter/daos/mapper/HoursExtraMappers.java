package com.amadeus.horas_extras.adapter.daos.mapper;

import com.amadeus.horas_extras.adapter.daos.entity.Boss;
import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import com.amadeus.horas_extras.adapter.daos.entity.ExtraHours;
import com.amadeus.horas_extras.domain.model.BossModel;
import com.amadeus.horas_extras.domain.model.EmployModel;
import com.amadeus.horas_extras.domain.model.ExtrasHoursModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface HoursExtraMappers {
    @Mappings({
            @Mapping(source = "startHours",target = "startHours"),
            @Mapping(source = "endHours",target = "endHours"),
            @Mapping(source = "dayTimeHours",target = "dayTimeHours"),
            @Mapping(source = "nightTimeHours",target = "nightTimeHours"),
            @Mapping(source = "dayHolidayHours",target = "dayHolidayHours"),
            @Mapping(source = "nightHolidayHours",target = "nightHolidayHours"),
            @Mapping(source = "valuedayhours",target = "valuedayhours"),
            @Mapping(source = "valuenighthours",target = "valuenighthours"),
            @Mapping(source = "valueDayHollidayHours",target = "valueDayHollidayHours"),
            @Mapping(source = "valueNightHolidayHours",target = "valueNightHolidayHours"),
            @Mapping(source = "valueday",target = "valueday"),
            @Mapping(source = "totalHoursValue",target = "totalHoursValue"),
            @Mapping(source = "createDate",target = "createDate"),
            @Mapping(source = "updateDate",target = "updateDate")
    })
    ExtraHours toExtraHoursModels(ExtrasHoursModel extrasHoursModel);
    @InheritInverseConfiguration
    ExtrasHoursModel fromExtraHours(ExtraHours extraHours);
    List<ExtrasHoursModel> toExtraHoursModel(List<ExtraHours> extraHoursList);
}
