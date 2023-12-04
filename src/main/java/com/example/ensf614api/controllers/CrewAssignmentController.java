package com.example.ensf614api.controllers;

import com.example.ensf614api.models.AvailableCrew;
import com.example.ensf614api.models.CrewAssignment;
import com.example.ensf614api.stores.CrewAssignmentStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/CrewAssignment")
public class CrewAssignmentController {
    private final CrewAssignmentStore crewAssignmentStore;


    public CrewAssignmentController(CrewAssignmentStore crewAssignmentStore) {
        this.crewAssignmentStore = crewAssignmentStore;
    }

    @GetMapping("AvailablePilots")
    public ResponseEntity<?> getAvailablePilots(){
        var availableCrew = this.crewAssignmentStore.GetAvailablePilots();
        if(availableCrew.size() == 0 ){
            return ResponseEntity.badRequest().body("No Crew Avaialble");
        }
        return ResponseEntity.ok(availableCrew);
    }

    @GetMapping("AvailableFas")
    public ResponseEntity<?> getAvailableFas(){
        var availableCrew = this.crewAssignmentStore.GetAvailableFas();
        if(availableCrew.size() == 0 ){
            return ResponseEntity.badRequest().body("No Crew Avaialble");
        }
        return ResponseEntity.ok(availableCrew);
    }

    @PostMapping("AssignCrew")
    public ResponseEntity<?> createNewCrewAssignment(@RequestBody CrewAssignment newAssignemnt){
        var assignment =  this.crewAssignmentStore.createCrewAssignment(newAssignemnt);
        if(assignment == null){
            return ResponseEntity.badRequest().body("Assignment unable to be created");
        }
        return ResponseEntity.ok(assignment);
    }

    @PostMapping("DeleteCrewAssignment")
    public ResponseEntity<?> deleteCrewAssignment(@RequestBody CrewAssignment crewAssignment){
        this.crewAssignmentStore.removeCrewAssignment(crewAssignment);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
