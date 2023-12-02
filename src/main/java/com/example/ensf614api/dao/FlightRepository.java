package com.example.ensf614api.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.ensf614api.models.Flight;

public interface FlightRepository extends CrudRepository<Flight, Integer> {
	
	@Query("select f from Flight f where f.origin=:origin "
			+ "and f.destination=:dest "
			+ "and f.departureDateTime=:departure")
	public Iterable<Flight> findByDetails(String origin, String dest, Date departure);
}
