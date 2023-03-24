package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Api("Сотрудники")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @ApiOperation("Загрузить сотрудников")
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody EmployeeDto employeeDto) {
        employeeService.loadEmployees(employeeDto);
        return ResponseEntity.ok().build();

    }

    @ApiOperation("Получить паиринги сотрудника")
    @GetMapping("/{id}/pairings")
    public ResponseEntity<?> getPairings(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.getPairingsByEmployee(id));
    }

    @ApiOperation("Получить паиринги сотрудника")
    @GetMapping("/{id}/flights")
    public ResponseEntity<?> getFlights(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.getFlights(id));
    }
}
