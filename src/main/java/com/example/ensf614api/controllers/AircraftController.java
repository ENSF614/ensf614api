package com.example.ensf614api.controllers;

import com.example.ensf614api.models.Aircraft;
import com.example.ensf614api.models.SignIn;
import com.example.ensf614api.models.User;
import com.example.ensf614api.stores.AircraftStore;
import com.example.ensf614api.stores.UserStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/Aircraft")
public class AircraftController {

    private final AircraftStore aircraftStore;

    public AircraftController(AircraftStore aircraftStore){this.aircraftStore = aircraftStore;}

    @GetMapping("getAircraft")
    public Iterable<Aircraft> getAllAircraft(){return aircraftStore.getAllAircraft();}

    @GetMapping("getAircraft/{aircraftId}")
    public Aircraft getAircraftById(@PathVariable("aircraftId")Integer aircraftId){return aircraftStore.getAircraftById(aircraftId);}
}
