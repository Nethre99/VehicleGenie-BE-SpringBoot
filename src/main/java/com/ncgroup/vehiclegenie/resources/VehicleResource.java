package com.ncgroup.vehiclegenie.resources;

import com.ncgroup.vehiclegenie.dto.AddVehicle;
import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import com.ncgroup.vehiclegenie.services.VehicleMgtService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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


    @GetMapping("/recommendations/{UserId}")
    public Flux<Vehicle> getRecommendationList(@PathVariable("UserId") int UserId){
        log.info("Get Recommendations for UserId {}", UserId);
        Flux<Vehicle> vehicleFlux = vehicleMgtService.getRecommendedVehicles(UserId);
        log.info("Vehicle Resource | getRecommendationList..!!");
        return vehicleFlux;
    }


    @PostMapping("/addvehicle")
    @ResponseBody
    public Flux<Vehicle> addVehicle(@RequestBody AddVehicle vehicle){
        log.info("Vehicle Resource | add vehicle: {}", vehicle.getTitle());
        Flux<Vehicle> vehicleFlux = vehicleMgtService.addVehicle(vehicle);
        log.info("Vehicle Resource | vehicle added successful..!!");
        return vehicleFlux;
    }
}
