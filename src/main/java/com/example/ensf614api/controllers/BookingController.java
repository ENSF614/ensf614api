package com.example.ensf614api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ensf614api.models.Booking;
import com.example.ensf614api.stores.BookingStore;

@CrossOrigin
@RestController
@RequestMapping("/api/Booking")
public class BookingController {

	private final BookingStore bookingStore;
	
	@Autowired
	public BookingController(BookingStore bookingStore) {
		this.bookingStore = bookingStore;
	}
	
	@GetMapping("getBooking/{id}")
	public Iterable<Booking> getBookingByFlightID(@PathVariable int id){
		return bookingStore.getBookingsByFlightID(id);
	}
	
	//get aircraft from flight id here.
	
}
