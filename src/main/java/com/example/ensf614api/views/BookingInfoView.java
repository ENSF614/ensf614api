package com.example.ensf614api.views;

public class BookingInfoView {

    private Double coachSeatPrice;
    private Double businessSeatPrice;
    private Integer numBusinessSeats;
    private Integer numRows;
    private Integer numCols;

    public BookingInfoView(Double coachSeatPrice, Double businessSeatPrice,
    						   Integer numBusinessSeats, Integer numRows, Integer numCols) {
			this.coachSeatPrice = coachSeatPrice;
			this.businessSeatPrice = businessSeatPrice;
			this.numBusinessSeats = numBusinessSeats;
			this.numRows = numRows;
			this.numCols = numCols;
		}

    public Double getCoachSeatPrice() {
        return coachSeatPrice;
    }

    public void setCoachSeatPrice(Double coachSeatPrice) {
        this.coachSeatPrice = coachSeatPrice;
    }

    public Double getBusinessSeatPrice() {
        return businessSeatPrice;
    }

    public void setBusinessSeatPrice(Double businessSeatPrice) {
        this.businessSeatPrice = businessSeatPrice;
    }
    
    public Integer getNumBusinessSeats() {
    	return numBusinessSeats;
    }
    
    public void setNumBusinessSeats(Integer numBusinessSeats) {
    	this.numBusinessSeats = numBusinessSeats;
    }

    public Integer getNumRows() {
        return numRows;
    }

    public void setNumRows(Integer numRows) {
        this.numRows = numRows;
    }

    public Integer getNumCols() {
        return numCols;
    }

    public void setNumCols(Integer numCols) {
        this.numCols = numCols;
    }
}

