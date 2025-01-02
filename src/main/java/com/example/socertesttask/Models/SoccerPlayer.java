package com.example.socertesttask.Models;

import jakarta.persistence.*;

@Entity
public class SoccerPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "experience")
    private short playExperience;

    private short age;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private SoccerTeam team;




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

    public short getPlayExperience() {
        return playExperience;
    }

    public void setPlayExperience(short playExperience) {
        this.playExperience = playExperience;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public SoccerTeam getTeam() {
        return team;
    }

    public void setTeam(SoccerTeam team) {
        this.team = team;
    }
}
