package com.example.socertesttask.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class SoccerTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal transferSum;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private SoccerPlayer player;

    @ManyToOne
    @JoinColumn(name = "to_team_id", nullable = false)
    private SoccerTeam toTeam;

    @ManyToOne
    @JoinColumn(name = "from_team_id", nullable = false)
    private SoccerTeam fromTeam;

    private LocalDate transferDate = LocalDate.now();

    public SoccerTransfer() {}

    public SoccerTransfer(BigDecimal transferSum, SoccerPlayer player, SoccerTeam toTeam, SoccerTeam fromTeam ,  LocalDate transferDate) {
        this.transferSum = transferSum;
        this.player = player;
        this.toTeam = toTeam;
        this.transferDate = transferDate;
        this.fromTeam = fromTeam;
    }

    public SoccerTeam getFromTeam() {
        return fromTeam;
    }

    public void setFromTeam(SoccerTeam fromTeam) {
        this.fromTeam = fromTeam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTransferSum() {
        return transferSum;
    }

    public void setTransferSum(BigDecimal transferSum) {
        this.transferSum = transferSum;
    }

    public SoccerPlayer getPlayer() {
        return player;
    }

    public void setPlayer(SoccerPlayer player) {
        this.player = player;
    }

    public SoccerTeam getToTeam() {
        return toTeam;
    }

    public void setToTeam(SoccerTeam toTeam) {
        this.toTeam = toTeam;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }
}
