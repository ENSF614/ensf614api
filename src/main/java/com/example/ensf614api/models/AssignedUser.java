package com.example.ensf614api.models;

import jakarta.persistence.Column;

public class AssignedUser extends User{

    @Column(name = "position")
    private String position;
    @Column(name = "flightID")
    private Integer flightID;
    @Column(name = "crewassignmentID")
    private Integer crewAssignmentId;

    public AssignedUser(User u, String position, Integer flightID, Integer crewassignmentID){
        super(u);
        this.position = position;
        this.flightID = flightID;
        this.crewAssignmentId = crewassignmentID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {

        this.flightID = flightID;
    }

    public int getCrewAssignmentId() {
        return crewAssignmentId;
    }

    public void setCrewAssignmentId(int crewAssignmentId) {

        this.crewAssignmentId = crewAssignmentId;
    }

}
