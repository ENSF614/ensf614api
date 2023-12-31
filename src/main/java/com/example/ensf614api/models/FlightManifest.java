package com.example.ensf614api.models;

import java.util.List;
import java.util.Optional;

public class FlightManifest {
    private Flight flight;
    private int capacity;
    private int booked;
    private Aircraft aircraft;
    private List<Booking> bookings;
    private List<AssignedUser> pilots;
    private List<AssignedUser> flightAttendants;

    public Flight getFlight() {return this.flight;}
    public void setFlight(Flight flight){this.flight = flight;}
    public int getCapacity(){return this.capacity;}
    public void setCapacity(int capacity){this.capacity = capacity;}
    public int getBooked(){return this.booked;}
    public void setBooked(int booked){this.booked = booked;}
    public Aircraft getAircraft(){return this.aircraft;}
    public void setAircraft(Aircraft aircraft){this.aircraft = aircraft;}
    public List<Booking> getBookings(){return this.bookings;}
    public void setBookings(List<Booking> bookings){this.bookings = bookings;}
    public List<AssignedUser> getPilots(){return this.pilots;}
    public void setPilots(List<AssignedUser> pilots){this.pilots = pilots;}
    public List<AssignedUser> getFlightAttendants(){return this.flightAttendants;}
    public void setFlightAttendants(List<AssignedUser> flightAttendants){this.flightAttendants = flightAttendants;}
}




