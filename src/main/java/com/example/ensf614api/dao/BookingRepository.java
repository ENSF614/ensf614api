package com.example.ensf614api.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.ensf614api.models.Booking;


public interface BookingRepository extends CrudRepository<Booking, Integer> {
	
	@Query("select b from Booking b where b.flightID=:flight_id")
	public Iterable<Booking> findByFlightID(@Param("flight_id") Integer flight_id);

	@Query("select b from Booking b where b.userID=:user_id")
	public Iterable<Booking> findByUserID(@Param("user_id") Integer user_id);
}
