package com.amadeus.horas_extras.adapter.daos.mapper;


import com.amadeus.horas_extras.adapter.daos.entity.Boss;
import com.amadeus.horas_extras.domain.model.BossModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BossMappers {
    @Mappings({

            @Mapping(source = "name",target = "name"),
            @Mapping(source = "lastName",target = "lastName"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "numberTelephone",target = "numberTelephone"),
            @Mapping(source = "area",target = "area"),
            @Mapping(source = "user",target = "user"),
            @Mapping(source = "password",target = "password"),
            @Mapping(source = "createDate",target = "createDate"),
            @Mapping(source = "updateDate",target = "updateDate")

    })
    Boss toBossModels(BossModel bossModel);
    @InheritInverseConfiguration
    BossModel fromBoss(Boss boss);
    List<BossModel> toBossModelsList(List<Boss> bosses);
    List<Boss> fromBossList(List<BossModel> bosses);
}
