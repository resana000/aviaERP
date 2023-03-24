package com.example.demo.mapper;

import com.example.demo.domain.Duties;
import com.example.demo.domain.Flight;
import com.example.demo.dto.DutiesItem;
import com.example.demo.dto.FlightsItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    List<Flight> mapToFlight(List<FlightsItem> flightDtos);

    @Mapping(target = "externalId", source = "dto.id")
    @Mapping(target = "flightNum", source = "dto.flightNum")
    @Mapping(target = "stationDeparture", source = "dto.stationDeparture")
    @Mapping(target = "stationArrival", source = "dto.stationArrival")
    @Mapping(target = "dateTimeDeparture", source = "dto.dateTimeDeparture")
    @Mapping(target = "dateTimeArrival", source = "dto.dateTimeArrival")
    Flight map(FlightsItem dto);

}
