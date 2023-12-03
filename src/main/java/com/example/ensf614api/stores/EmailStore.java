package com.example.ensf614api.stores;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.ensf614api.dao.FlightRepository;
import com.example.ensf614api.dao.UserRepository;
import com.example.ensf614api.models.Booking;
import com.example.ensf614api.models.Flight;
import com.example.ensf614api.models.User;
import com.example.ensf614api.views.CancelView;
import com.example.ensf614api.views.EmailDetails;

import jakarta.mail.internet.MimeMessage;

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
	
	private Map<String, String> getBookingEmailDetails(ArrayList<Booking> bookings) {
		
		User user = userRepo.getUser(
				String.valueOf(bookings.get(0).getUserID()));
		String email = user.getEmail();
		
		String emailSubject = "ENSF614 Airlines booking: ";
		String msgBody = user.getfName() + " " + user.getlName() +
				",\n\nThank you for booking with ENSF614 Airlines!"+
				" Your ticket(s) are attatched, if you have any questions"+
				" please reply to this email."+
				"\n\nSincerly,\nENSF614 Airlines";
		
		for(Booking booking : bookings) {
			emailSubject += booking.getBookingID() + " ";
		}
		
		HashMap<String, String> details = new HashMap<>();
		details.put("subject", emailSubject);
		details.put("body", msgBody);
		details.put("email", email);
		
		return details;
	}
	
	private boolean createReciept(ArrayList<Booking> bookings, String path) {
		
		User user = userRepo.getUser(
				String.valueOf(bookings.get(0).getUserID()));
		Flight flight = flightRepo.findById(bookings.get(0).getFlightID()).get();
		
		String bookingNumbers = "";
		for (Booking booking : bookings) {
			bookingNumbers += booking.getBookingID() + " ";
		}
		
		try {
			PDDocument doc = new PDDocument();
			PDPage page = new PDPage();
			doc.addPage(page);
			
			PDPageContentStream pdf = new PDPageContentStream(doc, page);
			pdf.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
			
			pdf.beginText();
			pdf.newLineAtOffset(25, 700);
			pdf.showText("Reciept for ticket(s) purchased on flight " 
					+ flight.getFlightNo() + ":");
			pdf.newLineAtOffset(0, -50);
			pdf.showText("Booking Number(s): " + bookingNumbers);
			pdf.newLineAtOffset(0, -50);
			pdf.showText("Charge: " + bookings.get(0).getPaid() + " CAD");
			pdf.newLineAtOffset(0, -50);
			pdf.showText("APPROVED");
			pdf.endText();
			pdf.close();
			
			doc.save(path);
			doc.close();
		}
		catch (Exception e) {
			System.out.println("Unable to make PDF" + e.getMessage());
			return false;
		}
		return true;	
	}
	
	public boolean sendBookingEmail(ArrayList<Booking> bookings) {
		
		Map<String, String> messageDetails = getBookingEmailDetails(bookings);
		
		try {
			SimpleMailMessage email = new SimpleMailMessage();
			email.setFrom(sender);
			email.setTo(messageDetails.get("email"));
			email.setSubject(messageDetails.get("subject"));
			email.setText(messageDetails.get("body"));
			
			
			javaMailSender.send(email);
			return true;
		}
		catch (Exception e) {
			System.out.println("Unable to send email" + e.getMessage());
			return false;
		}
	}
	
	public boolean sendBookingEmailWithAttatchment(ArrayList<Booking> bookings) {
		
		Map<String, String> messageDetails = getBookingEmailDetails(bookings);
		
		try {
			MimeMessage email = javaMailSender.createMimeMessage();
			MimeMessageHelper emailHelper = new MimeMessageHelper(email, true);
			
			emailHelper.setFrom(sender);
			emailHelper.setTo(messageDetails.get("email"));
			emailHelper.setSubject(messageDetails.get("subject"));
			emailHelper.setText(messageDetails.get("body"));
			
			String recieptPath = "reciepts/booking"+bookings.get(0).getBookingID()+".pdf";
			
			if(!createReciept(bookings, recieptPath)) {
				return false;
			}
			
			FileSystemResource pdf = new FileSystemResource(new File(recieptPath));
			emailHelper.addAttachment(recieptPath, pdf);
			
			javaMailSender.send(email);
			
		}
		catch (Exception e) {
			System.out.println("Unable to send email" + e.getMessage());
			return false;
		}
		return true;
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
