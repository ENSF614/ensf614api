package com.example.ensf614api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ensf614api.models.Booking;
import com.example.ensf614api.stores.BookingStore;
import com.example.ensf614api.views.BookingInfoView;
import com.example.ensf614api.views.CreditCard;
import com.example.ensf614api.views.SeatView;

@CrossOrigin
@RestController
@RequestMapping("/api/Booking")
public class BookingController {

	private final BookingStore bookingStore;
	
	@Autowired
	public BookingController(BookingStore bookingStore) {
		this.bookingStore = bookingStore;
	}
	
	@GetMapping("getBookingInfo/{id}")
	public BookingInfoView getBookingInfoByFlightID(@PathVariable int id) {
		return bookingStore.getBookingInfoByFlightID(id);
	}
	
	@GetMapping("getFlightSeats/{id}")
	public List<SeatView> getSeatsByFlightID(@PathVariable int id) {
		return bookingStore.getSeatsByFlightID(id);
	}
	
	@PostMapping("validateCard")
	public boolean validateCreditCard(@RequestBody CreditCard card) {
		System.out.println(card.getCardNumber());
		System.out.println(card.getCardExpiry());
		System.out.println(card.getCardCVV());
		
		return bookingStore.validateCreditCard(card);
	}
	
	@PutMapping("putBooking")
	public boolean putBooking(@RequestBody Booking booking) {
		return bookingStore.addBooking(booking);
	}
	
}
