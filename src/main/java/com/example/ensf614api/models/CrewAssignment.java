package com.example.ensf614api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "crewassignment")
public class CrewAssignment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CrewAssignmentID", nullable = false)
    private Integer crewAssignmentID;

    @Column(name = "crewID", nullable = false)
    private Integer crewID;

    @Column(name = "flightID", nullable = false)
    private Integer flightID;

    public Integer getCrewAssignmentID() {
        return this.crewAssignmentID;
    }

    public void setCrewAssignmentID(Integer crewAssignmentID) {
        this.crewAssignmentID = crewAssignmentID;
    }

    public Integer getCrewID() {
        return this.crewID;
    }

    public void setCrewID(Integer crewID) {
        this.crewID = crewID;
    }

    public Integer getFlightID() {
        return this.flightID;
    }

    public void setFlightID(Integer flightID) {
        this.flightID = flightID;
    }



}
