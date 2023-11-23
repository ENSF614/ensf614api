package com.example.ensf614api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ensf614api.models.Aircraft;

public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {

}
