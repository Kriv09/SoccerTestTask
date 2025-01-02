package com.example.socertesttask.Models.Requests;

import com.example.socertesttask.Models.SoccerTeam;

public class SoccerTransferRequest {
    private Long toTeamId;
    private Long soccerPlayerId;


    @Override
    public String toString() {
        return "SoccerTransferRequest{" +
                ", toTeamId=" + toTeamId +
                ", SoccerPlayerId=" + soccerPlayerId +
                '}';
    }
    public Long getToTeamId() {
        return toTeamId;
    }

    public void setToTeamId(Long toTeamId) {
        this.toTeamId = toTeamId;
    }

    public Long getSoccerPlayerId() {
        return soccerPlayerId;
    }

    public void setSoccerPlayerId(Long soccerPlayerId) {
        this.soccerPlayerId = soccerPlayerId;
    }
}
