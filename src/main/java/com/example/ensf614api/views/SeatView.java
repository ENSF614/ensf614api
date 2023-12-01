package com.example.ensf614api.views;

public class SeatView {

	private Integer seatRow;
	private String seatCol;
	private Boolean booked;
	private Integer flightID;
	private Boolean businessClass;
	private Double price;
	private String passengerName;
	
	public SeatView(Integer seatRow, String seatCol, 
					Boolean booked, Integer flightID, 
					Boolean seatClass, Double price,
					String passengerName) {
        this.seatRow = seatRow;
        this.seatCol = seatCol;
        this.booked = booked;
        this.flightID = flightID;
        this.businessClass = seatClass;
        this.price = price;
        this.passengerName = passengerName;
    }

    // Getter and Setter for seatRow
    public Integer getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(Integer seatRow) {
        this.seatRow = seatRow;
    }

    // Getter and Setter for seatCol
    public String getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(String seatCol) {
        this.seatCol = seatCol;
    }

    // Getter and Setter for booked
    public Boolean getBooked() {
        return booked;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
    }

    // Getter and Setter for flightID
    public Integer getFlightID() {
        return flightID;
    }

    public void setFlightID(Integer flightID) {
        this.flightID = flightID;
    }

    // Getter and Setter for seatClass
    public Boolean getBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(Boolean seatClass) {
        this.businessClass = seatClass;
    }

    // Getter and Setter for price
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPassengerName() {
    	return this.passengerName;
    }
    
    public void setPassengerName(String name) {
    	this.passengerName = name;
    }

}
