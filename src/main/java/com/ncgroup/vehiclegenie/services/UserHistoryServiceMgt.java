package com.ncgroup.vehiclegenie.services;

import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import reactor.core.publisher.Mono;

public interface UserHistoryServiceMgt {

    /**
     * addWatchedAdd
     * @param userId
     * @param vehicleId
     * @return
     */
    Mono<Vehicle> addWatchedAdd(int userId, int vehicleId);
}
