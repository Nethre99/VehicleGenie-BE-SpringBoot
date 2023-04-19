package com.ncgroup.vehiclegenie.client;

import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import reactor.core.publisher.Flux;

public interface VehicleGenieClient {

    /**
     * Get Recommendations
     *
     * @param UserId
     * @return
     */
    Flux<Vehicle> getRecommendations(int UserId);
}
