package com.ncgroup.vehiclegenie.services.impl;

import com.ncgroup.vehiclegenie.client.impl.VehicleGenieClientImpl;
import com.ncgroup.vehiclegenie.dto.AddVehicle;
import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import com.ncgroup.vehiclegenie.repository.VehicleRepository;
import com.ncgroup.vehiclegenie.services.VehicleMgtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class VehicleMgtServiceImpl implements VehicleMgtService {

    private final VehicleGenieClientImpl vehicleGenieClient;
    private final VehicleRepository vehicleRepository;

    public VehicleMgtServiceImpl(VehicleGenieClientImpl vehicleGenieClient, VehicleRepository vehicleRepository) {
        this.vehicleGenieClient = vehicleGenieClient;
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public Flux<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.getAllVehicles();
        return Flux.fromIterable(vehicles);
    }

    @Override
    public Flux<Vehicle> getRecommendedVehicles(int UserId){
        log.info("Get Recommendations | user id: {}", UserId);
        Flux<Vehicle> vehicles = vehicleGenieClient.getRecommendations(UserId);
        log.info("VehicleGenie Recommendation Service | Get Recommendations for User: {}", UserId);
        return vehicles;
    }

    @Override
    public Mono<Vehicle> addVehicle(AddVehicle addvehicle) {
        return null;
    }
}
