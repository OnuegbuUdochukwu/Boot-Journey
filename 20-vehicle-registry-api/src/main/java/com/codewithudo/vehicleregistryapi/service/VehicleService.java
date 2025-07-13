package com.codewithudo.vehicleregistryapi.service;

import com.codewithudo.vehicleregistryapi.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    private final List<Vehicle> vehicles = new ArrayList<>();
    private int nextId = 1;

    // Add a new vehicle
    public boolean addVehicle(Vehicle vehicle) {
        vehicle.setId(nextId++);
        vehicles.add(vehicle);
        return true;
    }

    // Get all vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    // Get a vehicle by ID
    public Vehicle getVehicleById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(id)) {
                return vehicle;
            }
        }
        return null;
    }

    // Update vehicle details by ID
    public boolean updateVehicle(int id, Vehicle updatedVehicle) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(id)) {
                vehicle.setRegistrationNumber(updatedVehicle.getRegistrationNumber());
                vehicle.setOwnerName(updatedVehicle.getOwnerName());
                vehicle.setModel(updatedVehicle.getModel());
                vehicle.setManufacturer(updatedVehicle.getManufacturer());
                vehicle.setYear(updatedVehicle.getYear());
                vehicle.setColor(updatedVehicle.getColor());
                return true;
            }
        }
        return false;
    }

    // Delete a vehicle by ID
    public boolean deleteVehicle(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(id)) {
                vehicles.remove(vehicle);
                return true;
            }
        }
        return false;
    }
}
