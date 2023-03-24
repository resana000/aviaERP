package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;

    @Override
    public void loadEmployees(EmployeeDto employeeDtos) {
        employeeRepository.saveAll(mapper.mapToEmployee(employeeDtos.getEmployees()));
    }

    @Override
    public Optional<Employee> getByEmployeeId(String employeeId) {
        return employeeRepository.findEmployeeByExternalId(employeeId);
    }

    @Override
    public List<Pairing> getPairingsByEmployee(String employeeId) {
        Optional<Employee> employeeOptional = getByEmployeeId(employeeId);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get().getPairings().stream()
                    .map(PairingAssigment::getPairing).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<String> getEmployeeExternalIds() {
        return employeeRepository.findAllExternalIds();
    }

    @Override
    public void saveAll(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

    @Override
    public List<Flight> getFlights(String id) {
        Optional<Employee> employeeOptional = getByEmployeeId(id);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get().getFlights().stream()
                    .map(EmployeeFlight::getFlight).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }    }
}
