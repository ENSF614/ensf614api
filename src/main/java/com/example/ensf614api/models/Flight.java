package com.example.ensf614api.models;

import java.util.Date;

public class Flight {
    private int flightId;
    private String flightNo;
    private String origin;
    private String destination;
    private Date departureDateTime;
    private Date arrivalDateTime;
    private int capacity;

    public int getFlightId(){
        return this.flightId;
    }
    public void setFlightId(int Id){
        this.flightId=Id;
    }

    public String getFlightNo(){
        return this.flightNo;
    }
    public void setFlightNo(String flightNo){
        this.flightNo = flightNo;
    }

    public String getOrigin(){
        return this.origin;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }

    public String getDestination(){
        return this.destination;
    }
    public void setDestination(String destination){
        this.destination = destination;
    }
    public Date getDepartureDateTime(){
        return this.departureDateTime;
    }
    public void setDepartureDateTime(Date departureDateTime){
        this.departureDateTime = departureDateTime;
    }

    public Date getArrivalDateTime(){
        return this.arrivalDateTime;
    }
    public void  setArrivalDateTime(Date arrivalDateTime){
        this.arrivalDateTime = arrivalDateTime;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
}
