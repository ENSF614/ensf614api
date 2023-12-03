package com.example.ensf614api.controllers;

import com.example.ensf614api.stores.ManifestStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/Manifest")
public class ManifestController {

    private final ManifestStore manifestStore;

    @Autowired
    public ManifestController(ManifestStore manifestStore) {
        this.manifestStore = manifestStore;
    }

    @GetMapping("getManifests")
    public ResponseEntity<?> getAllManifests(){
        var manifests = manifestStore.GetFlightManifests();
        if (manifests.size() == 0){
            return ResponseEntity.badRequest().body("No Flight Manifests Found");
        }
        return ResponseEntity.ok(manifests);
    }

    @GetMapping("getManifest/{flightId}")
    public ResponseEntity<?> getAllManifestByFlightId(@PathVariable("flightId") Integer flightId){
        var manifest = manifestStore.GetFlightManifestByFlight(flightId);
        if (manifest == null){
            return ResponseEntity.badRequest().body("No Flight Manifests Found");
        }
        return ResponseEntity.ok(manifest);
    }
}
