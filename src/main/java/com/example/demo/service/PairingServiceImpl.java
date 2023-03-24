package com.example.demo.service;

import com.example.demo.domain.Flight;
import com.example.demo.domain.Pairing;
import com.example.demo.dto.*;
import com.example.demo.mapper.PairingMapper;
import com.example.demo.repository.PairingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PairingServiceImpl implements PairingService {

    private final PairingRepository pairingRepository;
    private final PairingMapper pairingMapper;
    private final EmployeeService employeeService;
    private final FlightService flightService;

    @Override
    public void populatePairingAssignments(final RosterDto pairingDtos) {
        log.info("incoming assigments size: {}", pairingDtos.getAssignments().size());
        final List<PairingsItem> pairingsItems = pairingDtos.getPairings();
        final List<AssignmentsItem> savedAssignments = new ArrayList<>();

        List<Pairing> pairingList = new ArrayList<>();
        pairingsItems.stream().forEach(pairingsItem -> {
            for (AssignmentsItem assignment : pairingDtos.getAssignments()) {
                if (pairingsItem.getPairingId().equals(assignment.getPairingID())) {
                    final Pairing pairing = pairingMapper.map(pairingsItem);
                    pairingList.add(pairing);
                    employeeService.getByEmployeeId(assignment.getEmployeeID())
                            .ifPresent(e -> {
                                e.addFlights(getFlights(pairingsItem.getDuties()));
                                e.addPairing(pairing, assignment.getRank());
                                savedAssignments.add(assignment);
                            });
                }
            }
        });

        pairingRepository.saveAll(pairingList);
        pairingDtos.getAssignments().removeAll(savedAssignments);
        log.warn("Non saved pairing assignments: {}", pairingDtos.getAssignments().size());
        log.info("Saved pairing assignments: {}", savedAssignments.size());

    }

    public List<Flight> getFlights(List<DutiesItem> dutiesList) {
        if (dutiesList == null) return Collections.emptyList();
        List<String> flightIds = dutiesList.stream().flatMap(q -> q.getLegs().stream())
                .map(LegsItem::getFlightID).collect(Collectors.toList());
        return flightService.getAllIn(flightIds);
    }
}
