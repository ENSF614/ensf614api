package com.example.ensf614api.stores;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ensf614api.dao.AircraftRepository;
import com.example.ensf614api.dao.BookingRepository;
import com.example.ensf614api.dao.FlightRepository;
import com.example.ensf614api.models.Aircraft;
import com.example.ensf614api.models.Booking;
import com.example.ensf614api.models.Flight;

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
	
	public Iterable<Booking> getBookingsByFlightID(int id){
		return bookingRepo.findByFlightID(id);
	}
	
	public Optional<Aircraft> getAircraftByID(int id){
		return aircraftRepo.findById(id);
	}
	
	public Optional<Flight> getFlightByID(int id){
		return flightRepo.findById(id);
	}
}
