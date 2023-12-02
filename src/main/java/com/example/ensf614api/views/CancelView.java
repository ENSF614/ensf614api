package com.example.ensf614api.views;

public class CancelView {

	private Integer bookingID;
	private String userID;
	private Integer flightID;
	private Boolean cancelInsurance;

	public CancelView(Integer bookingID, String userID, Integer flightID, Boolean cancelInsurance) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.flightID = flightID;
        this.cancelInsurance = cancelInsurance;
    }

    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
}
