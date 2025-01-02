package com.example.socertesttask.Services;

import com.example.socertesttask.Models.Requests.SoccerPlayerAddRequest;
import com.example.socertesttask.Models.SoccerPlayer;
import com.example.socertesttask.Models.SoccerTeam;
import com.example.socertesttask.Repositories.SoccerPlayerRepository;
import com.example.socertesttask.Repositories.SoccerTeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoccerPlayerService {

    private final SoccerPlayerRepository soccerPlayerRepository;
    private final SoccerTeamRepository soccerTeamRepository;

    public SoccerPlayerService(SoccerPlayerRepository soccerPlayerRepository, SoccerTeamRepository soccerTeamRepository) {
        this.soccerPlayerRepository = soccerPlayerRepository;
        this.soccerTeamRepository = soccerTeamRepository;
    }

    public SoccerPlayer createPlayer(SoccerPlayerAddRequest soccerPlayerRequest) {
        SoccerPlayer soccerPlayer = new SoccerPlayer();
        soccerPlayer.setName(soccerPlayerRequest.getName());
        soccerPlayer.setPlayExperience(soccerPlayerRequest.getPlayExperience());
        soccerPlayer.setAge(soccerPlayerRequest.getAge());

        if (soccerPlayerRequest.getTeamId() != null) {
            SoccerTeam team = soccerTeamRepository.findById(soccerPlayerRequest.getTeamId())
                    .orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + soccerPlayerRequest.getTeamId()));
            soccerPlayer.setTeam(team);
        }

        return soccerPlayerRepository.save(soccerPlayer);
    }


    public List<SoccerPlayer> getAllPlayers() {
        return soccerPlayerRepository.findAll();
    }

    public SoccerPlayer getPlayerById(Long id) {
        return soccerPlayerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with id: " + id));
    }

    public SoccerPlayer updatePlayer(Long id, SoccerPlayer soccerPlayerDetails) {
        SoccerPlayer soccerPlayer = soccerPlayerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with id: " + id));

        soccerPlayer.setName(soccerPlayerDetails.getName());
        soccerPlayer.setAge(soccerPlayerDetails.getAge());
        soccerPlayer.setPlayExperience(soccerPlayerDetails.getPlayExperience());

        if (soccerPlayerDetails.getTeam() != null && soccerPlayerDetails.getTeam().getId() != null) {
            SoccerTeam team = soccerTeamRepository.findById(soccerPlayerDetails.getTeam().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + soccerPlayerDetails.getTeam().getId()));
            soccerPlayer.setTeam(team);
        }

        return soccerPlayerRepository.save(soccerPlayer);
    }

    public void deletePlayer(Long id) {
        SoccerPlayer soccerPlayer = soccerPlayerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with id: " + id));
        soccerPlayerRepository.delete(soccerPlayer);
    }
}
