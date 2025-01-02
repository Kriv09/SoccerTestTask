package com.example.socertesttask.Services;

import com.example.socertesttask.Models.SoccerTeam;
import com.example.socertesttask.Repositories.SoccerTeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoccerTeamService {

    private final SoccerTeamRepository soccerTeamRepository;

    public SoccerTeamService(SoccerTeamRepository soccerTeamRepository) {
        this.soccerTeamRepository = soccerTeamRepository;
    }

    public SoccerTeam createTeam(SoccerTeam soccerTeam) {
        return soccerTeamRepository.save(soccerTeam);
    }

    public List<SoccerTeam> getAllTeams() {
        return soccerTeamRepository.findAll();
    }

    public SoccerTeam getTeamById(Long id) {
        return soccerTeamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + id));
    }

    public SoccerTeam updateTeam(Long id, SoccerTeam soccerTeamDetails) {
        SoccerTeam soccerTeam = soccerTeamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + id));

        soccerTeam.setName(soccerTeamDetails.getName());
        soccerTeam.setPlayers(soccerTeamDetails.getPlayers());

        return soccerTeamRepository.save(soccerTeam);
    }

    public void deleteTeam(Long id) {
        SoccerTeam soccerTeam = soccerTeamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + id));
        soccerTeamRepository.delete(soccerTeam);
    }
}
