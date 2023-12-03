package com.example.ensf614api.controllers;

import com.example.ensf614api.stores.ManifestStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
