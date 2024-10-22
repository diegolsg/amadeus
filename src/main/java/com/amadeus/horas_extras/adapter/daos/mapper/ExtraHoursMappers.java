package com.amadeus.horas_extras.adapter.daos.mapper;

import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface ExtraHoursMappers {
      @Mappings({
              @Mapping(source = "document", target = "document"),
              @Mapping(source = "name", target = "name"),
              @Mapping(source = "lastName", target = "lastName"),
              @Mapping(source = "email", target = "email"),
              @Mapping(source = "numberTelephone", target = "numberTelephone"),
              @Mapping(source = "position", target = "position"),
              @Mapping(source = "salary", target = "salary"),
              @Mapping(source = "area", target = "area")})
      Employ toEmployModels(EmployModel employModel);
     @InheritInverseConfiguration
      EmployModel fromEmploy(Employ employ);
}
