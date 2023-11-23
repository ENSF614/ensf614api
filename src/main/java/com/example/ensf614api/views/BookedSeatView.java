package com.example.ensf614api.views;

public class BookedSeatView {
	
	private Integer seatRow;
	private String seatCol;
	
	public BookedSeatView(Integer seatRow, String seatCol) {
		this.seatRow = seatRow;
		this.seatCol = seatCol;
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
}
