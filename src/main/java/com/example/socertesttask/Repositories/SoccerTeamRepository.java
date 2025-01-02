package com.example.socertesttask.Repositories;

import com.example.socertesttask.Models.SoccerTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoccerTeamRepository extends JpaRepository<SoccerTeam, Long> {
}
