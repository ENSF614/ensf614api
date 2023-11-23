package com.example.ensf614api.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "flightid", nullable=false)
    private Integer flightId;
	@Column(name = "flightnumber")
    private String flightNo;
	@Column(name = "origin")
    private String origin;
	@Column(name = "destination")
    private String destination;
	@Column(name = "departuredatetime")
    private Date departureDateTime;
	@Column(name = "arrivaldatetime")
    private Date arrivalDateTime;
	@Column(name = "aircraftid")
    private Integer aircraftID;
	@Column(name = "coachseatprice")
	private Double coachSeatPrice;
	@Column(name = "businessseatprice")
	private Double businessSeatPrice;

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
    
    public Integer getAircraftID() {
    	return this.aircraftID;
    }
    
    public void setAircraftID(int id) {
    	this.aircraftID = id;
    }
    
    public Double getCoachSeatPrice() {
    	return this.coachSeatPrice;
    }
    
    public void setCoachSeatPrice(double price) {
    	this.coachSeatPrice = price;
    }
    
    public Double getBusinessSeatPrice() {
    	return this.businessSeatPrice;
    }
    
    public void setBusinessSeatPrice(double price) {
    	this.businessSeatPrice = price;
    }
}
