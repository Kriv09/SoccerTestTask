package com.example.socertesttask.Repositories;

import com.example.socertesttask.Models.SoccerTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoccerTransferRepository extends JpaRepository<SoccerTransfer,Long> {
}
