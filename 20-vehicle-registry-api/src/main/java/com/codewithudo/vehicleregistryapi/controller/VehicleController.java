package com.codewithudo.vehicleregistryapi.controller;

import com.codewithudo.vehicleregistryapi.model.Vehicle;
import com.codewithudo.vehicleregistryapi.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Create a new vehicle
    @PostMapping
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        boolean added = vehicleService.addVehicle(vehicle);
        if (added) {
            return new ResponseEntity<>("Vehicle added successfully.", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed to add vehicle.", HttpStatus.BAD_REQUEST);
    }

    // Get all vehicles
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    // Get a vehicle by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable int id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle != null) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update a vehicle by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {
        boolean updated = vehicleService.updateVehicle(id, vehicle);
        if (updated) {
            return new ResponseEntity<>("Vehicle updated successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Vehicle not found.", HttpStatus.NOT_FOUND);
    }

    // Delete a vehicle by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable int id) {
        boolean deleted = vehicleService.deleteVehicle(id);
        if (deleted) {
            return new ResponseEntity<>("Vehicle deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Vehicle not found.", HttpStatus.NOT_FOUND);
    }
}
