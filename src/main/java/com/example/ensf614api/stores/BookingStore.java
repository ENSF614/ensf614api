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
import com.example.ensf614api.views.BookedSeatView;
import com.example.ensf614api.views.BookingInfoView;

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
	
	public List<BookedSeatView> getBookedSeats(int flightID){
		Iterable<Booking> bookings = bookingRepo.findByFlightID(flightID);
		
		List<BookedSeatView> bookedSeats = new ArrayList<>();
		for(Booking booking : bookings) {
			bookedSeats.add(
					new BookedSeatView(
							booking.getSeatRow(),
							booking.getSeatCol()
							)
					);
		}
		return bookedSeats;
	}
	
	public BookingInfoView getBookingInfoByFlightID(int id){
		Flight flight = flightRepo.findById(id).get();
		Aircraft aircraft = aircraftRepo.findById(flight.getAircraftID()).get();
		
		return new BookingInfoView(
					flight.getCoachSeatPrice(),
					flight.getBusinessSeatPrice(),
					aircraft.getNumBusinessSeats(),
					aircraft.getRowNums(),
					aircraft.getColNums()
				);
	}
}
