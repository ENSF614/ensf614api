package com.example.ensf614api.stores;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.example.ensf614api.dao.BookingRepository;
import com.example.ensf614api.dao.FlightRepository;
import com.example.ensf614api.models.Booking;
import com.example.ensf614api.models.Flight;
import com.example.ensf614api.views.FlightSearchView;
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
	
	public Iterable<Flight> getFlights(){
		return flightRepo.findAll();
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
	
	public Iterable<Flight> getFlightsByDetails(FlightSearchView flightDetails){
		var allFlights = flightRepo.findAll();

		Stream<Flight> stream = StreamSupport.stream(allFlights.spliterator(), false);

		List<Flight> filteredList = stream
				.filter(x -> x.getOrigin()
				.equals(flightDetails.getOrigin()))
				.filter(x -> x.getDestination()
						.equals(flightDetails.getDestination()))
				.filter(x -> x.getDepartureDateTime()
						.toInstant()
						.atZone(ZoneId.systemDefault()).toLocalDate()
						.equals(flightDetails
								.getDepartureDateTime()
								.toInstant()
								.atZone(ZoneId.systemDefault())
								.toLocalDate()))
				.collect(Collectors.toList());
		return filteredList;

	}

}
