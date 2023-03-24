package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.domain.Flight;
import com.example.demo.domain.Pairing;
import com.example.demo.dto.EmployeeDto;
import org.apache.kafka.common.protocol.types.Field;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void loadEmployees(EmployeeDto employeeDtos);
    Optional<Employee> getByEmployeeId(String employeeId);
    List<Pairing> getPairingsByEmployee(String id);
    List<String> getEmployeeExternalIds();
    void saveAll(List<Employee> employees);
    Iterable<Flight> getFlights(String id);
}
