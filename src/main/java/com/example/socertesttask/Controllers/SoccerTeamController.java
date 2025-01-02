package com.example.socertesttask.Controllers;

import com.example.socertesttask.Models.SoccerTeam;
import com.example.socertesttask.Services.SoccerTeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class SoccerTeamController {

    private final SoccerTeamService soccerTeamService;

    public SoccerTeamController(SoccerTeamService soccerTeamService) {
        this.soccerTeamService = soccerTeamService;
    }

    @PostMapping
    public ResponseEntity<SoccerTeam> createTeam(@RequestBody SoccerTeam soccerTeam) {
        SoccerTeam createdTeam = soccerTeamService.createTeam(soccerTeam);
        return ResponseEntity.ok(createdTeam);
    }

    @GetMapping
    public ResponseEntity<List<SoccerTeam>> getAllTeams() {
        List<SoccerTeam> teams = soccerTeamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoccerTeam> getTeamById(@PathVariable Long id) {
        SoccerTeam team = soccerTeamService.getTeamById(id);
        return ResponseEntity.ok(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SoccerTeam> updateTeam(@PathVariable Long id, @RequestBody SoccerTeam soccerTeamDetails) {
        SoccerTeam updatedTeam = soccerTeamService.updateTeam(id, soccerTeamDetails);
        return ResponseEntity.ok(updatedTeam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        soccerTeamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}
