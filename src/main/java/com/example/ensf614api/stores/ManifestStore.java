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
public class ManifestStore {

    private FlightRepository flightRepo;

    private BookingRepository bookingRepo;

    private AircraftRepository aircraftRepo;

    private UserRepository userRepo;

    public ManifestStore(FlightRepository flightRepo, BookingRepository bookingRepo, AircraftRepository aircraftRepo, UserRepository userRepo){
        this.flightRepo = flightRepo;
        this.bookingRepo = bookingRepo;
        this.aircraftRepo = aircraftRepo;
        this.userRepo = userRepo;
    }

    public List<FlightManifest> GetFlightManifests(){
        List<Flight> flights = StreamSupport.stream(flightRepo.findAll().spliterator(), false).collect(Collectors.toList());
        List<Booking> allBookings = StreamSupport.stream(bookingRepo.findAll().spliterator(), false).collect(Collectors.toList());
        List<Aircraft> aircraftList = StreamSupport.stream(aircraftRepo.findAll().spliterator(), false).collect(Collectors.toList());
        List<FlightManifest> manifestList = new ArrayList<FlightManifest>();

        for(Flight flight : flights){
            Aircraft ac = aircraftList.stream().filter(x -> x.getAircraftID().equals(flight.getAircraftID())).findFirst().orElseThrow(() -> new NoSuchElementException("No Aircraft found for this flight"));
            Aircraft aircraft = aircraftRepo.findById(flight.getAircraftID()).orElseThrow(() -> new NoSuchElementException("No aircraft found for this flight."));
            var bookings = allBookings.stream().filter(x -> x.getFlightID().equals(flight.getFlightId())).collect(Collectors.toList());
            var count = bookings.size();
//            var pilots = userRepo.getPilots(flight.getFlightId());
//            var fa = userRepo.getFas(flight.getFlightId());

            var manifest = new FlightManifest();
            manifest.setAircraft(aircraft);
            manifest.setCapacity(aircraft.getCapacity());
            manifest.setBooked(count);
            manifest.setFlight(flight);
            manifest.setBookings(bookings);
//            manifest.setPilots(pilots);
//            manifest.setFlightAttendants(fa);

            manifestList.add(manifest);

        }

        return manifestList;
    }

    public FlightManifest GetFlightManifestByFlight(Integer flightID){
        Flight flight = flightRepo.findById(flightID).orElseThrow(()-> new NoSuchElementException("No Flight found"));
        List<Booking> allBookings = StreamSupport.stream(bookingRepo.findAll().spliterator(), false).collect(Collectors.toList());

        Aircraft aircraft = aircraftRepo.findById(flight.getAircraftID()).orElseThrow(() -> new NoSuchElementException("No aircraft found for this flight."));
        var bookings = allBookings.stream().filter(x -> x.getFlightID().equals(flight.getFlightId())).collect(Collectors.toList());
        var count = bookings.size();
        var pilots = userRepo.getPilots(flight.getFlightId());
        var fa = userRepo.getFas(flight.getFlightId());

        var manifest = new FlightManifest();
        manifest.setAircraft(aircraft);
        manifest.setCapacity(aircraft.getCapacity());
        manifest.setBooked(count);
        manifest.setFlight(flight);
        manifest.setBookings(bookings);
        manifest.setPilots(pilots);
        manifest.setFlightAttendants(fa);

        return manifest;
    }
}
