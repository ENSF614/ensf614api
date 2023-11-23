package com.example.ensf614api.stores;

import com.example.ensf614api.models.Flight;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DbStore {
	
	// This is where all interaction with the DB will take place, I havent implemented any stores,  jsut some bullshit data to work with to start.
    public List<Flight> getFlights(){
        List<Flight> flights = new ArrayList<>();
        List<String> cities = Arrays.asList("Calgary", "Edmonton", "Red Deer", "Lethbridge");

        for (int i = 1; i <= 10; i++) {
            Flight flight = new Flight();
            flight.setFlightId(i);
            flight.setFlightNo("AB123" + i);
            flight.setOrigin(cities.get(i % cities.size()));
            flight.setDestination(cities.get((i + 1) % cities.size()));
            flight.setDepartureDateTime(new GregorianCalendar(2023, Calendar.NOVEMBER, i, 9 + i % 4, 0).getTime());
            flight.setArrivalDateTime(new GregorianCalendar(2023, Calendar.NOVEMBER, i, 11 + i % 4, 0).getTime());
            flight.setCapacity(100 + i * 10);
            flights.add(flight);
        }

        return flights;
    }
    
    
}
