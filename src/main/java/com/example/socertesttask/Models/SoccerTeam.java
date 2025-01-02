package com.example.socertesttask.Models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Entity
public class SoccerTeam {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "balance" , nullable = false)
    private BigDecimal balance;

    @Value("${SoccerTeamDefaultCurrencyValue}")
    private short board;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = false)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<SoccerPlayer> players;


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public short getBoard() {
        return board;
    }

    public void setBoard(short board) {
        this.board = board;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SoccerPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<SoccerPlayer> players) {
        this.players = players;
    }
}
