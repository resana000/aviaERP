package com.example.demo.controller;

import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.RosterDto;
import com.example.demo.service.PairingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pairings")
@Api("Pairings")
@RequiredArgsConstructor
public class PairingsController {

    private final PairingService pairingService;

    @ApiOperation("Загрузить рейсы и назначения")
    @PostMapping("/populate-assigments")
    public ResponseEntity add(@RequestBody RosterDto rosterDto) {
        pairingService.populatePairingAssignments(rosterDto);
        return ResponseEntity.ok().build();

    }
}
