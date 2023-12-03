package com.example.ensf614api.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "crew")
public class Crew {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "crewID", nullable = false)
    private Integer crewID;

    @Column(name = "userID", nullable = false)
    private Integer userID;

    @Column(name = "position", nullable = false)
    private String position;

    public Integer getCrewID(){return this.crewID;}
    public void setCrewID(Integer crewID){this.crewID = crewID;}
    public Integer getUserID(){return this.userID;}
    public void setUserID(Integer userID){this.userID = userID;}
    public String getPosition(){return this.position;}
    public void setPosition(String position){this.position = position;}
}
