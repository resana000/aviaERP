package com.example.demo.controller;

import com.example.demo.dto.FlightsDto;
import com.example.demo.dto.MessageResponse;
import com.example.demo.service.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
@Api("Рейсы")
@RequiredArgsConstructor
public class FlightsController {

    private final FlightService flightService;

    @ApiOperation("Загрузить рейсы")
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody FlightsDto flightsDto) {
        flightService.save(flightsDto);
        return ResponseEntity.ok().build();

    }
}
