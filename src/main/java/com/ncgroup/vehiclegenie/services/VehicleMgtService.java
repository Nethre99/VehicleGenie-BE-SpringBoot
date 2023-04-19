package com.ncgroup.vehiclegenie.services;

import com.ncgroup.vehiclegenie.dto.AddVehicle;
import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
     * @param - UserId
     * @return - List of vehicle recommendations
     */
    Flux<Vehicle> getRecommendedVehicles(int UserId);

    /**
     * Add Vehicle
     *
     * @param addvehicle
     * @return
     */
    Mono<Vehicle> addVehicle(AddVehicle addvehicle);

}
