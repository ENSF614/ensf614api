package com.example.ensf614api.stores;

import java.awt.print.Book;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.example.ensf614api.dao.AircraftRepository;
import com.example.ensf614api.dao.UserRepository;
import com.example.ensf614api.models.*;
import org.springframework.stereotype.Service;

import com.example.ensf614api.dao.BookingRepository;
import com.example.ensf614api.dao.FlightRepository;
import com.example.ensf614api.views.FlightSearchView;
import com.example.ensf614api.views.UserFlightInfoView;

@Service
public class AircraftStore {

    private AircraftRepository aircraftRepo;

    public AircraftStore(AircraftRepository aircraftRepo){
        this.aircraftRepo = aircraftRepo;
    }

    public Iterable<Aircraft> getAllAircraft(){
        return aircraftRepo.findAll();
    }

    public Aircraft getAircraftById(Integer aircraftId){
        return aircraftRepo.findById(aircraftId).orElseThrow(() -> new NoSuchElementException("Aircraft not found"));
    }
}
