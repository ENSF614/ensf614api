package com.example.ensf614api.stores;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.ensf614api.dao.BookingRepository;
import com.example.ensf614api.dao.FlightRepository;
import com.example.ensf614api.models.Booking;
import com.example.ensf614api.models.Flight;
import com.example.ensf614api.views.UserFlightInfoView;

@Service
public class FlightStore {

	private FlightRepository flightRepo;
	private BookingRepository bookingRepo;
	
	public FlightStore(FlightRepository flightRepo,
					   BookingRepository bookingRepo) {
		this.flightRepo = flightRepo;
		this.bookingRepo = bookingRepo;
	}
	
	public ArrayList<UserFlightInfoView> getUserFlightInfo(Integer userID){
		
		ArrayList<UserFlightInfoView> userFlightInfo = new ArrayList<>();
		
		Iterable<Booking> bookings = bookingRepo.findByUserID(Integer.valueOf(userID));
		for(Booking booking : bookings) {
			Flight flight = flightRepo.findById(booking.getFlightID()).get();
			userFlightInfo.add(
					new UserFlightInfoView(
							booking.getBookingID(),
							booking.getFlightID(),
							booking.getCancelInsurance(),
							booking.getSeatClass(),
							booking.getSeatRow(),
							booking.getSeatCol(),
							booking.getPassengerName(),
							flight.getFlightNo(),
							flight.getOrigin(),
							flight.getDestination(),
							flight.getDepartureDateTime(),
							flight.getArrivalDateTime()
							)
					);
		}
		return userFlightInfo;
	}

}
