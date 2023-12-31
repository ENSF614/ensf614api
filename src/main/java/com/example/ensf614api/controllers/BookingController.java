package com.example.ensf614api.controllers;

import java.util.ArrayList;
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
import com.example.ensf614api.stores.EmailStore;
import com.example.ensf614api.views.BookingInfoView;
import com.example.ensf614api.views.CancelView;
import com.example.ensf614api.views.CreditCard;
import com.example.ensf614api.views.SeatView;

@CrossOrigin
@RestController
@RequestMapping("/api/Booking")
public class BookingController {

	private final BookingStore bookingStore;
	private final EmailStore emailStore;
	
	@Autowired
	public BookingController(BookingStore bookingStore,
							 EmailStore emailStore) {
		this.bookingStore = bookingStore;
		this.emailStore = emailStore;
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
		return bookingStore.validateCreditCard(card);
	}
	
	@PutMapping("putBooking")
	public boolean putBooking(@RequestBody Booking booking) {
		return bookingStore.addBooking(booking);
	}
	
	@PutMapping("putBookings")
	public String putBookings(@RequestBody ArrayList<Booking> bookings) {
		if(!bookingStore.addBookings(bookings))
			return "unable to make booking";
		if(!emailStore.sendBookingEmailWithAttatchment(bookings))
			return "unable to send email";
		return "successful booking";
	}
	
	@PostMapping("cancelBooking")
	public String cancelBooking(@RequestBody CancelView cancel) {
		if(!bookingStore.cancelBooking(cancel.getBookingID()))
			return "Failed to cancel booking";
		if(!emailStore.sendCancellationEmail(cancel))
			return "Failed to send confirmation email";
		return "success";
	}
	
}
