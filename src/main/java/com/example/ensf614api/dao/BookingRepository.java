package com.example.ensf614api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ensf614api.models.Booking;


public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
