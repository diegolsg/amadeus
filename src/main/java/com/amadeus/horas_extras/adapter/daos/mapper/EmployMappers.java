package com.amadeus.horas_extras.adapter.daos.mapper;

import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import com.amadeus.horas_extras.adapter.daos.entity.Position;
import com.amadeus.horas_extras.domain.model.EmployModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.xml.transform.Source;
import java.math.BigDecimal;


@Mapper(componentModel = "spring")
public interface EmployMappers {
      @Mappings({
              @Mapping(source = "document", target = "document"),
              @Mapping(source = "name", target = "name"),
              @Mapping(source = "lastName", target = "lastName"),
              @Mapping(source = "email", target = "email"),
              @Mapping(source = "numberTelephone", target = "numberTelephone"),
              @Mapping(source = "position", target = "position"),
              @Mapping(source = "user", target = "user"),
              @Mapping(source = "password", target = "password"),
              @Mapping(source = "salary", target = "salary"),
              @Mapping(source = "area", target = "area"),
              @Mapping(source = "createDate", target = "createDate"),
              @Mapping(source = "updateDate", target = "updateDate")
      })

      Employ toEmployModels(EmployModel employModel);
     @InheritInverseConfiguration
     EmployModel fromEmploy(Employ employ);
}
