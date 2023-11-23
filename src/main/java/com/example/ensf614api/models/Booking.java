package com.example.ensf614api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "bookingid", nullable = false)
	private Integer bookingID;
	@Column(name = "userid", nullable = false)
	private Integer userID;
	@Column(name = "flightid", nullable = false)
	private Integer flightID;
	@Column(name = "cancelinsurance")
	private Boolean cancelInsurance;
	@Column(name = "paid")
	private Boolean paid;
	@Column(name = "paymethod")
	private String payMethod;
	@Column(name = "class")
	private String seatClass;
	@Column(name = "seatrow")
    private Integer seatRow;
	@Column(name = "seatcol")
    private String seatCol;

    // Getter and setter methods for bookingID
    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    // Getter and setter methods for user
    public int getUserID() {
        return userID;
    }

    public void setUser(int user) {
        this.userID = user;
    }

    // Getter and setter methods for flightID
    public Integer getFlightID() {
        return flightID;
    }

    public void setFlightID(Integer flightID) {
        this.flightID = flightID;
    }

    // Getter and setter methods for cancelInsurance
    public Boolean getCancelInsurance() {
        return cancelInsurance;
    }

    public void setCancelInsurance(Boolean cancelInsurance) {
        this.cancelInsurance = cancelInsurance;
    }

    // Getter and setter methods for paid
    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    // Getter and setter methods for payMethod
    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    // Getter and setter methods for flightClass
    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    // Getter and setter methods for seatRowNumber
    public Integer getSeatRow() {
        return seatRow;
    }

    public void setSeatRowNumber(Integer seatRowNumber) {
        this.seatRow = seatRowNumber;
    }

    // Getter and setter methods for seatCol
    public String getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(String seatCol) {
        this.seatCol = seatCol;
    }
}
