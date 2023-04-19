package com.ncgroup.vehiclegenie.services.impl;

import com.ncgroup.vehiclegenie.client.impl.VehicleGenieClientImpl;
import com.ncgroup.vehiclegenie.dto.AddVehicle;
import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import com.ncgroup.vehiclegenie.services.VehicleMgtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class VehicleMgtServiceImpl implements VehicleMgtService {

    private final VehicleGenieClientImpl vehicleGenieClient;

    public VehicleMgtServiceImpl(VehicleGenieClientImpl vehicleGenieClient) {
        this.vehicleGenieClient = vehicleGenieClient;
    }


    @Override
    public Flux<Vehicle> getAllVehicles() {
        return null;
    }

    @Override
    public Flux<Vehicle> getRecommendedVehicles(int UserId) {
        log.info("VehicleGenie Recommendation Service | Get Recommendations for User: {}", UserId);
        Flux<Vehicle> recommendations = vehicleGenieClient.getRecommendations(UserId);

        return null;
    }

    @Override
    public Mono<Vehicle> addVehicle(AddVehicle addvehicle) {
        return null;
    }
}
