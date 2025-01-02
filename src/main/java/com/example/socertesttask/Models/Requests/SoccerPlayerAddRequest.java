package com.example.socertesttask.Models.Requests;

public class SoccerPlayerAddRequest {

    private String name;
    private short playExperience;
    private short age;
    private Long teamId;

    public SoccerPlayerAddRequest() {}

    public SoccerPlayerAddRequest(String name, short playExperience, short age, Long teamId) {
        this.name = name;
        this.playExperience = playExperience;
        this.age = age;
        this.teamId = teamId;
    }

    // Getters and setters
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

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
