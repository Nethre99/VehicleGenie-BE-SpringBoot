package com.ncgroup.vehiclegenie.client.impl;

import com.ncgroup.vehiclegenie.client.VehicleGenieClient;
import com.ncgroup.vehiclegenie.dto.models.Vehicle;
import com.ncgroup.vehiclegenie.exception.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Service
@Slf4j
public class VehicleGenieClientImpl implements VehicleGenieClient{

    private final WebClient webClient;
    private final Scheduler scheduler;

    public VehicleGenieClientImpl(@Qualifier("vehicle-genie-ml")  WebClient webClient, Scheduler scheduler) {
        this.webClient = webClient;
        this.scheduler = scheduler;
    }


    @Override
    public Flux<Vehicle> getRecommendations(int UserId) {
        return webClient.get()
                .uri("/getRecommendations/{UserId}", UserId)
                .retrieve()
                .onStatus(HttpStatus::isError, response -> {
                    log.info("Get Recommendation Client Status: {}", response);
                    return Mono.error(new ErrorMessage(response.toString()));
                })
                .bodyToFlux(Vehicle.class).subscribeOn(scheduler).publishOn(scheduler);
    }
}
