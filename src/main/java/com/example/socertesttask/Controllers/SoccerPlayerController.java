package com.example.socertesttask.Controllers;

import com.example.socertesttask.Models.Requests.SoccerPlayerAddRequest;
import com.example.socertesttask.Models.SoccerPlayer;
import com.example.socertesttask.Services.SoccerPlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class SoccerPlayerController {

    private final SoccerPlayerService soccerPlayerService;

    public SoccerPlayerController(SoccerPlayerService soccerPlayerService) {
        this.soccerPlayerService = soccerPlayerService;
    }

    @PostMapping
    public ResponseEntity<SoccerPlayer> createPlayer(@RequestBody SoccerPlayerAddRequest soccerPlayerAddRequest) {
        SoccerPlayer createdPlayer = soccerPlayerService.createPlayer(soccerPlayerAddRequest);
        return ResponseEntity.ok(createdPlayer);
    }

    @GetMapping
    public ResponseEntity<List<SoccerPlayer>> getAllPlayers() {
        List<SoccerPlayer> players = soccerPlayerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoccerPlayer> getPlayerById(@PathVariable Long id) {
        SoccerPlayer player = soccerPlayerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SoccerPlayer> updatePlayer(@PathVariable Long id, @RequestBody SoccerPlayer soccerPlayerDetails) {
        SoccerPlayer updatedPlayer = soccerPlayerService.updatePlayer(id, soccerPlayerDetails);
        return ResponseEntity.ok(updatedPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        soccerPlayerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}
