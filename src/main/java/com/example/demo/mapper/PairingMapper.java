package com.example.demo.mapper;

import com.example.demo.domain.Duties;
import com.example.demo.domain.Legs;
import com.example.demo.domain.Pairing;
import com.example.demo.dto.DutiesItem;
import com.example.demo.dto.LegsItem;
import com.example.demo.dto.PairingsItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PairingMapper {

    List<Pairing> mapToPairing(List<PairingsItem> pairingsItems);

    @Mapping(target = "fleet", source = "dto.fleet")
    @Mapping(target = "dateTimeStart", source = "dto.dateTimeStart")
    @Mapping(target = "dateTimeEnd", source = "dto.dateTimeEnd")
    @Mapping(target = "pairingID", source = "dto.pairingId")
    @Mapping(target = "duties", source = "dto.duties")
    Pairing map(PairingsItem dto);

    @Mapping(target = "dateTimeEnd", source = "dto.dateTimeEnd")
    @Mapping(target = "dateTimeStart", source = "dto.dateTimeStart")
    @Mapping(target = "legs", source = "dto.legs")
    Duties dutiesMap(DutiesItem dto);

    @Mapping(target = "type", source = "dto.type")
    @Mapping(target = "flightID", source = "dto.flightID")
    Legs legsMap(LegsItem dto);
}
