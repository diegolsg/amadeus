package com.amadeus.horas_extras.adapter.daos.mapper;

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
              @Mapping(source = "document", target = "document"),
              @Mapping(source = "document", target = "document"),
              @Mapping(source = "document", target = "document"),

      })
//              @Mapping(source = "documentSinister", target = "documentSinister"),
//              @Mapping(source = "state", target = "state"),
//              @Mapping(source = "recoveredValue", target = "recoveredValue"),})
//      Sinister toSinisterModels(SinisterModels sinisterModels);
//      @InheritInverseConfiguration
//      SinisterModels fromSinister(Sinister sinister);
}
