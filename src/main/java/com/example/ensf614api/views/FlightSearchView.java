package com.example.ensf614api.views;

import java.util.Date;

public class FlightSearchView {

	private String origin;
	private String destination;
	private Date departureDateTime;
	
	public FlightSearchView(String origin, String destination, Date departureDateTime) {
        this.origin = origin;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }
}
