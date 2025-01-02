package com.example.socertesttask.Repositories;

import com.example.socertesttask.Models.SoccerPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoccerPlayerRepository extends JpaRepository<SoccerPlayer, Long> {
}
