package com.example.demo.service;

import com.example.demo.domain.Flight;
import com.example.demo.dto.FlightsDto;
import com.example.demo.mapper.FlightMapper;
import com.example.demo.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository repository;
    private final FlightMapper mapper;

    @Override
    public void save(FlightsDto flightDtos) {
        repository.saveAll(mapper.mapToFlight(flightDtos.getFlights()));
    }

    @Override
    public Optional<Flight> getByFlightNum(String flightNum) {
        return repository.findFlightByFlightNum(flightNum);
    }

    @Override
    public List<Flight> getAllIn(List<String> flightIds) {
        return repository.findAllByExternalIdIsIn(flightIds);
    }
}
