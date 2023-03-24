package com.example.demo.mapper;

import com.example.demo.domain.Employee;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeesItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmployeeMapperTest {

    EmployeeMapper employeeMapper = new EmployeeMapperImpl();

    @Test
    void mapEmployees() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployees(
                List.of(new EmployeesItem("fleet", null, null, null, "citizenship", "ID", "gender", null, null)));
        List<Employee> employees = employeeMapper.mapToEmployee(employeeDto.getEmployees());

        Assertions.assertAll(
                () -> assertNotNull(employees),
                () -> assertEquals(employees.get(0).getFleet(), employeeDto.getEmployees().get(0).getFleet()),
                () -> assertEquals(employees.get(0).getGender(), employeeDto.getEmployees().get(0).getGender())
        );

    }
}
