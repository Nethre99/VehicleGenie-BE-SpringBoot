package com.ncgroup.vehiclegenie.repository;

import com.ncgroup.vehiclegenie.dto.models.Vehicle;

import java.util.List;

public interface VehicleRepository {

    List<Vehicle> addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();

    Vehicle getVehicleById(int vehicleId);
}
