package com.ncgroup.vehiclegenie.resources;

import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import com.ncgroup.vehiclegenie.services.UserHistoryServiceMgt;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RequestMapping("add")
@Slf4j
@AllArgsConstructor
@RestController
public class UserHistoryResource {

    private final UserHistoryServiceMgt userHistoryServiceMgt;

    @PostMapping("/{userId}/{vehicleId}")
    public Mono<Vehicle> addWatchedVehicle(@PathVariable("userId") int userId,@PathVariable("vehicleId") int vehicleId){

        log.info("add watched {}, {}", userId, vehicleId);
        Mono<Vehicle> vehicleMono = userHistoryServiceMgt.addWatchedAdd(userId, vehicleId);
        log.info("User History | addWatchedVehicle: {}", vehicleMono);
        return vehicleMono;

    }
}
