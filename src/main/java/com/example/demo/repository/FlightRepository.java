package com.example.demo.repository;

import com.example.demo.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findById(Long id);

    Optional<Flight> findFlightByFlightNum(String flightNum);

    List<Flight> findAllByExternalIdIsIn(List<String> flightIds);
}
