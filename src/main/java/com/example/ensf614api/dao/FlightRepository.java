package com.example.ensf614api.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.ensf614api.models.Flight;

public interface FlightRepository extends CrudRepository<Flight, Integer> {

}
