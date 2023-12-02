package com.example.ensf614api.stores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.ensf614api.dao.FlightRepository;
import com.example.ensf614api.dao.UserRepository;
import com.example.ensf614api.models.Booking;
import com.example.ensf614api.models.Flight;
import com.example.ensf614api.models.User;
import com.example.ensf614api.views.CancelView;
import com.example.ensf614api.views.EmailDetails;

@Service
public class EmailStore {

	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${spring.mail.username}")
	private String sender;
	private UserRepository userRepo;
	private FlightRepository flightRepo;
	
	public EmailStore(UserRepository userRepo,
					  FlightRepository flightRepo) {
		this.userRepo = userRepo;
		this.flightRepo = flightRepo;
	}
	
	public boolean sendBookingEmail(ArrayList<Booking> bookings) {
		
		User user = userRepo.getUser(
				String.valueOf(bookings.get(0).getUserID()));
		String email = user.getEmail();
		
		try {
			String emailSubject = "ENSF614 Airlines booking: ";
			String msgBody = user.getfName() + " " + user.getlName() +
					",\n\nThank you for booking with ENSF614 Airlines!"+
					" Your ticket(s) are attatched, if you have any questions"+
					" please reply to this email."+
					"\n\nSincerly,\nENSF614 Airlines";
			
			for(Booking booking : bookings) {
				emailSubject += booking.getBookingID() + " ";
			}
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(email);
			mailMessage.setSubject(emailSubject);
			mailMessage.setText(msgBody);
			
			
			javaMailSender.send(mailMessage);
			return true;
		}
		catch (Exception e) {
			System.out.println("Unable to send email" + e.getMessage());
			return false;
		}
	}
	
	public boolean sendCancellationEmail(CancelView cancel) {
		
		Flight flight = flightRepo.findById(cancel.getFlightID()).get();
		String flightNo = flight.getFlightNo();
		User user = userRepo.findById(Integer.valueOf(cancel.getUserID())).get();
		String email = user.getEmail();
		
		try {
			String emailSubject = "ENSF614 Airlines Cancellation: ";
			String msgBody = user.getfName() + " " + user.getlName() +
					",\n\nThis is a confirmation of your cancellation for "+
					" booking number " + cancel.getBookingID() + 
					" for flight " + flightNo + ".";
			
			if(cancel.getCancelInsurance()) {
				msgBody += " Because you had cancellation insurance we" +
						   " fully refunded your ticket.";
			}
			
			msgBody += "\n\nSincerly,\nENSF614 Airlines";
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(email);
			mailMessage.setSubject(emailSubject);
			mailMessage.setText(msgBody);
			
			
			javaMailSender.send(mailMessage);
			return true;
		}
		catch (Exception e) {
			System.out.println("Unable to send email" + e.getMessage());
			return false;
		}
	}

}
