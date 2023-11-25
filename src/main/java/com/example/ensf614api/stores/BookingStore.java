package com.example.ensf614api.stores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ensf614api.dao.AircraftRepository;
import com.example.ensf614api.dao.BookingRepository;
import com.example.ensf614api.dao.FlightRepository;
import com.example.ensf614api.models.Aircraft;
import com.example.ensf614api.models.Booking;
import com.example.ensf614api.models.Flight;
import com.example.ensf614api.views.BookingInfoView;
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
	
}
