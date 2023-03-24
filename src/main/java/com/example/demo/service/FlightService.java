package com.example.demo.service;

import com.example.demo.domain.Flight;
import com.example.demo.dto.FlightsDto;

import java.util.List;
import java.util.Optional;

public interface FlightService {

    void save(FlightsDto flightDtos);
    Optional<Flight> getByFlightNum(String flightNum);
    List<Flight> getAllIn(List<String> flightIds);

}
