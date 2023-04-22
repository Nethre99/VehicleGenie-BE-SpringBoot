package com.ncgroup.vehiclegenie.services;

import com.ncgroup.vehiclegenie.dto.AddVehicle;
import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import reactor.core.publisher.Flux;

public interface VehicleMgtService {

    /**
     * Get All Available Vehicles
     *
     * @return - List of vehicles
     */
    Flux<Vehicle> getAllVehicles();

    /**
     * Get Recommended Vehicles
     *
     * @return - List of vehicle recommendations
     */
    Flux<Vehicle> getRecommendedVehicles(int UserId);

    /**
     * Add Vehicle
     *
     * @return vehicle list
     */
    Flux<Vehicle> addVehicle(AddVehicle addvehicle);

}
