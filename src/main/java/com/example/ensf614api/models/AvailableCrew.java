package com.example.ensf614api.models;

import jakarta.persistence.Column;


public class AvailableCrew extends User{

    @Column(name = "position")
    private String position;
    @Column(name = "crewID")
    private Integer crewID;

    public AvailableCrew(User u, String position, Integer crewID){
        super(u);
        this.position = position;
        this.crewID = crewID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getCrewID() {
        return crewID;
    }

    public void setCrewID(int crewID) {

        this.crewID = crewID;
    }
}

