package com.ncgroup.vehiclegenie.resources;

import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import com.ncgroup.vehiclegenie.services.VehicleMgtService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RequestMapping("vehicle")
@RestController
@AllArgsConstructor
public class VehicleResource {

    @Autowired
    private final VehicleMgtService vehicleMgtService;


    @GetMapping
    public Flux<Vehicle> getAllVehicles(){
        Flux<Vehicle> vehicleFlux = vehicleMgtService.getAllVehicles();
        log.info("VehicleResource | getAllVehicles: done");
        return vehicleFlux;
    }
}
