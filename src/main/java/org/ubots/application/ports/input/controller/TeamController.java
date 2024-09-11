package org.ubots.application.ports.input.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ubots.domain.service.TeamService;

@AllArgsConstructor
@RestController
@RequestMapping("/service-desk/team")
public class TeamController {

    private TeamService teamService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<String> all() {
        return ResponseEntity.ok(teamService.all());
    }

}
