package com.example.ensf614api.views;

import java.util.Date;

public class UserFlightInfoView {

	private Integer bookingID;
	private Integer flightID;
	private Boolean cancelInsurance;
	private String seatClass;
	private Integer seatRow;
	private String seatCol;
	private String passengerName;
	private String flightNumber;
	private String origin;
	private String destination;
	private Date departureDateTime;
	private Date arrivalDateTime;
	
	public UserFlightInfoView(Integer bookingID, Integer flightID, Boolean cancelInsurance,
            String seatClass, Integer seatRow, String seatCol, String passengerName,
            String flightNumber, String origin, String destination, Date departureDateTime,
            Date arrivalDateTime) {
        this.bookingID = bookingID;
        this.flightID = flightID;
        this.cancelInsurance = cancelInsurance;
        this.seatClass = seatClass;
        this.seatRow = seatRow;
        this.seatCol = seatCol;
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }

    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public Integer getFlightID() {
        return flightID;
    }

    public void setFlightID(Integer flightID) {
        this.flightID = flightID;
    }

    public Boolean getCancelInsurance() {
        return cancelInsurance;
    }

    public void setCancelInsurance(Boolean cancelInsurance) {
        this.cancelInsurance = cancelInsurance;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public Integer getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(Integer seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(String seatCol) {
        this.seatCol = seatCol;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }
}
