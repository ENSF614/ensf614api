package com.example.ensf614api.stores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ensf614api.dao.AircraftRepository;
import com.example.ensf614api.dao.BookingRepository;
import com.example.ensf614api.dao.FlightRepository;
import com.example.ensf614api.models.Aircraft;
import com.example.ensf614api.models.Booking;
import com.example.ensf614api.models.Flight;
import com.example.ensf614api.views.BookingInfoView;
import com.example.ensf614api.views.CreditCard;
import com.example.ensf614api.views.SeatView;

@Service
public class BookingStore {
	
	private AircraftRepository aircraftRepo;
	private BookingRepository bookingRepo;
	private FlightRepository flightRepo;
	
	public BookingStore(AircraftRepository aircraftRepo,
						BookingRepository bookingRepo,
						FlightRepository flightRepo) {
		this.aircraftRepo = aircraftRepo;
		this.bookingRepo = bookingRepo;
		this.flightRepo = flightRepo;
	}
	
	public BookingInfoView getBookingInfoByFlightID(int id){
		Flight flight = flightRepo.findById(id).get();
		Aircraft aircraft = aircraftRepo.findById(flight.getAircraftID()).get();
		
		return new BookingInfoView(
					flight.getCoachSeatPrice(),
					flight.getBusinessSeatPrice(),
					aircraft.getNumBusinessRows(),
					aircraft.getRowNums(),
					aircraft.getColNums()
				);
	}
	
	public List<SeatView> getSeatsByFlightID(int id){
		Flight flight = flightRepo.findById(id).get();
		Aircraft aircraft = aircraftRepo.findById(flight.getAircraftID()).get();
		Iterable<Booking> bookings = bookingRepo.findByFlightID(id);
		
		boolean businessClass = true;
		List<SeatView> seats = new ArrayList<>();
		for(int i=1; i<aircraft.getRowNums(); i++) {
			
			if(i > aircraft.getNumBusinessRows())
				businessClass = false;
			
			for(char j='A'; j<'A'+aircraft.getColNums()*2; j++) {
				seats.add(
						new SeatView(
								i, String.valueOf(j), false,
								flight.getFlightId(), businessClass,
								businessClass ? flight.getBusinessSeatPrice() : flight.getCoachSeatPrice()
								)
						);
			}
		}
		
		//add booked flag to seats
		for(Booking booking : bookings) {
			int row = booking.getSeatRow();
			String col = booking.getSeatCol();
			for(SeatView seat : seats) {
				if(row == seat.getSeatRow() && col.equals(seat.getSeatCol())) {
					seat.setBooked(true);
					continue;
				}
			}
		}
		return seats;
	}
	
	private boolean validateNumber(String number) {
		String num = number.replaceAll("[^0-9]", "");
		if(num.length() != 16)
			return false;
		return true;
	}
	
	private boolean validateCVV(String cvv) {
		String num = cvv.replaceAll("[^0-9]", "");
		if(num.length() != 3)
			return false;
		return true;
	}
	
	private boolean validateExpiry(String expiry) {
		String num = expiry.replaceAll("[^0-9]", "");
		
		if(num.length() != 4)
			return false;
		
		int month = Integer.valueOf(num.substring(0,2));
		System.out.println("Month: " + month);
		if(month < 1 || month > 12)
			return false;
		
		int year = Integer.valueOf(num.substring(2));
		System.out.println("Year: " + year);
		LocalDate thisDate = LocalDate.now();
		
		int thisYear = Integer.valueOf(Integer.valueOf(thisDate.getYear()).toString().substring(2));
		System.out.println("This year: " + thisYear);
		if(year < thisYear)
			return false;
		
		int thisMonth = thisDate.getMonthValue();
		System.out.println("This month: " + thisMonth);
		if(month < thisMonth && year == thisYear)
			return false;
		
		return true;
	}
	
	public boolean validateCreditCard(CreditCard card) {
		boolean num = validateNumber(card.getCardNumber());
		boolean cvv = validateCVV(card.getCardCVV());
		boolean exp = validateExpiry(card.getCardExpiry());
		return num && cvv && exp;
	}
	
	public boolean addBooking(Booking booking) {
		try {
			bookingRepo.save(booking);
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	
}
