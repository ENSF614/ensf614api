package com.example.ensf614api.controllers;

import com.example.ensf614api.models.Flight;
import com.example.ensf614api.stores.DbStore;
import com.example.ensf614api.stores.FlightStore;
import com.example.ensf614api.views.UserFlightInfoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/Flight")
public class FlightController {

	private final DbStore store = new DbStore();
	private final FlightStore flightStore;
	
	@Autowired
	public FlightController(FlightStore flightStore) {
		this.flightStore = flightStore;
	}

	@GetMapping("getFlights")
    public ResponseEntity<List<Flight>> getAllFlights(){
	    return new ResponseEntity<>(store.getFlights(), HttpStatus.OK);
	}

	@GetMapping("getFlights/{userid}")
	public ResponseEntity<List<UserFlightInfoView>> getFlightsByUserID(@PathVariable Integer userid) {
		return new ResponseEntity<>(flightStore.getUserFlightInfo(userid), HttpStatus.OK);
	}

}
